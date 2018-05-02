/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */
package guava;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * FuturesUtil
 *
 * @author luobosi@2dfire.com
 * @since 2018-05-02
 */
public class FuturesUtil {

    /**
     * 有一个任务返回了结果 则立即结束
     * 适用于任务的结果导致主线程直接结束的处理方式
     *
     * @param allFutures 所有任务的集合
     * @param timeout    任务超时时长
     * @param unit       任务超时时长单位
     * @return <T> 返回某一个任务的结果
     * @throws Exception 多线程异常，非业务异常
     */
    @SuppressWarnings(value = "unchecked")
    public static <T> T handleWithOneReturn(ListenableFuture<List<ReturnEntity>> allFutures, long timeout, TimeUnit unit) throws Exception {
        Preconditions.checkNotNull(allFutures);
        List<ReturnEntity> allReturnEntity = catchFutureGetException(allFutures, timeout, unit);
        Preconditions.checkNotNull(allReturnEntity);
        for (ReturnEntity entity : allReturnEntity) {
            if (null != entity) {
                entity.throwException();
                if (entity.hashResult()) {
                    allFutures.cancel(true);
                    return (T) entity.getResult();
                }
            }
        }
        return null;
    }


    /**
     * 返回所有任务处理的结果
     *
     * @param allFutures 所有任务的集合
     * @param timeout    任务超时时长
     * @param unit       任务超时时长单位
     * @return 所有任务的结果集
     * @throws Exception
     */
    public static List<ReturnEntity> handleWithAllReturn(ListenableFuture<List<ReturnEntity>> allFutures, long timeout, TimeUnit unit) throws Exception {
        Preconditions.checkNotNull(allFutures);
        List<ReturnEntity> returnEntityList = Lists.newArrayList();
        List<ReturnEntity> allReturnEntity = catchFutureGetException(allFutures, timeout, unit);
        Preconditions.checkNotNull(allReturnEntity);
        for (ReturnEntity returnEntity : allReturnEntity) {
            Preconditions.checkNotNull(returnEntity);
            returnEntity.throwException();
            returnEntityList.add(returnEntity);
        }
        return returnEntityList;
    }

    /**
     * 无结果返回
     *
     * @param allFutures 所有任务的集合
     * @param timeout    任务超时时长
     * @param unit       任务超时时长单位
     * @throws Exception
     */
    public static void handleWithOutReturn(ListenableFuture<List<ReturnEntity>> allFutures, long timeout, TimeUnit unit) throws Exception {
        Preconditions.checkNotNull(allFutures);
        List<ReturnEntity> allReturnEntity = catchFutureGetException(allFutures, timeout, unit);
        Preconditions.checkNotNull(allReturnEntity);
        for (ReturnEntity returnEntity : allReturnEntity) {
            Preconditions.checkNotNull(returnEntity);
            returnEntity.throwException();
        }
    }

    /**
     * 从异步任务异步任务结果中获得指定的结果
     *
     * @param returnEntityList 所有的异步任务的结果
     * @param index            指定的异步任务结果
     * @param size             所有的异步任务结果数量总和
     * @return 获得任务的结果
     */
    @SuppressWarnings(value = "unchecked")
    public static <T> T fetch(List<ReturnEntity> returnEntityList, int index, int size) {
        if (null != returnEntityList && returnEntityList.size() == size) {
            ReturnEntity returnEntity = returnEntityList.get(index);
            if (returnEntity != null && returnEntity.hashResult()) {
                return (T) returnEntity.getResult();
            }
        }
        return null;
    }


    /**
     * 取消任务
     *
     * @param allFutures 所有任务的集合
     */
    public static void cancel(ListenableFuture<List<ReturnEntity>> allFutures) {
        if (allFutures != null) {
            allFutures.cancel(true);
        }
    }

    /**
     * 获得异步任务的结果，捕获异常并记录到日志
     *
     * @param allFutures 所有任务的集合
     * @param timeout    任务超时时长
     * @param unit       任务超时时长单位
     * @return 任务的结果
     * @throws Exception
     */
    private static List<ReturnEntity> catchFutureGetException(ListenableFuture<List<ReturnEntity>> allFutures, long timeout, TimeUnit unit) throws Exception {
        try {
            return allFutures.get(timeout, unit);
        } catch (Exception e) {
            FuturesUtil.cancel(allFutures);
            // 这里应该打日志
            // LoggerUtil.error(WXLoggerFactory.ASYN_TASK_MONITOR_LOGGER, LoggerMarkers.ASYN_TASK_ERROR, e);
            throw e;
        }
    }
}