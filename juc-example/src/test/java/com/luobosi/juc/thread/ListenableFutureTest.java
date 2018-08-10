package com.luobosi.juc.thread;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import guava.AsynTask;
import guava.ReturnEntity;
import guava.ThreadPoolManager;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * ListenableFutureTest
 *
 * @author luobosi@2dfire.com
 * @since 2018-05-02
 */
public class ListenableFutureTest {
    static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
    static ThreadPoolManager threadPoolManager = ThreadPoolManager.INSTANCE;

    static ThreadPoolManager threadPoolManager1 = ThreadPoolManager.INSTANCE;

    public static void test() throws Exception {
        for (int i = 0; i < 300; i++) {
            ListenableFuture<ReturnEntity> future1 = threadPoolManager.addExecuteTask(AsynTask.newTask("test asynTask 1").registExecute(new AsynTask.Execute() {
                @Override
                public Object execute() throws Exception {
                    return testPrint1();
                }
            }));
        }
    }

    static int i = 1;

    private static List<String> testPrint1() throws Exception {
        System.out.println("---------->" + i++);
        System.out.println(Runtime.getRuntime().availableProcessors());
        Thread.sleep(3000);
        return Lists.newArrayList("test print result 1", "22222");
    }

    private static String testPrint2() throws Exception {
        System.out.println("test print 2");
        Thread.sleep(30000);
        int a = 11 + 4;
        return null;
    }

    private static String testPrint3() throws Exception {
        Thread.sleep(500);
        System.out.println("test print 3");
        int a = 11 + 2;
        if (a > 100) {
            throw new Exception("test exception 3");
        }
        return "test print result 3";
    }



    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis());
            service.shutdownNow();
        }

    }

//        for (int i =0 ;i<12;i++){
//            ListenableFuture<ReturnEntity> future1 = threadPoolManager1.addExecuteTask(AsynTask.newTask("test asynTask 1").registExecute(new AsynTask.Execute() {
//                @Override
//                public Object execute() throws Exception {
//                    return testPrint2();
//                }
//            }));
//        }

//        ListenableFuture<ReturnEntity> future2 = service.submit(AsynTask.newTask("test asynTask 2").registExecute(new AsynTask.Execute() {
//            @Override
//            public Object execute() throws Exception {
//                return testPrint2();
//            }
//        }));
//
//        ListenableFuture<ReturnEntity> future3 = service.submit(AsynTask.newTask("test asynTask 3").registExecute(new AsynTask.Execute() {
//            @Override
//            public Object execute() throws Exception {
//                return testPrint3();
//            }
//        }));
//        System.out.println(FuturesUtil.asList(null,null) == null?"null":"not null");
//        CheckedFuture<ReturnEntity,Exception> a = Futures.makeChecked(future3,new Function<Exception, Exception>(){
//
//            @Override
//            public Exception apply(Exception e) {
//                return null;
//            }
//        });
//        a.checkedGet();
//        List<ListenableFuture<ReturnEntity>> tmpList = Lists.newArrayList();
//        tmpList.add(future1);
//        tmpList.add(future2);
//        final ListenableFuture<List<ReturnEntity>> allFutures = Futures.successfulAsList(tmpList);
//        try {
//
//            ReturnEntity entity3 = future3.get(1000,TimeUnit.MILLISECONDS);
//            entity3.throwException();
//            List<ReturnEntity> returnEntityList = allFutures.get(10000, TimeUnit.MILLISECONDS);
//            for (ReturnEntity returnEntity : returnEntityList) {
//                if (null != returnEntity) {
//                    System.out.println(returnEntity);
//                    if(returnEntity.hashResult()) {
//                        System.out.println(returnEntity.getResult());
//                    }
//                    returnEntity.throwException();
//                }
//            }
//            System.out.println("over !");
//        } catch (Exception e) {
////            allFutures.cancel(true);
//            throw new Exception(e);

}
