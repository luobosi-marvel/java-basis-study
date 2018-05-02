package com.luobosi.juc.thread;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import guava.AsynTask;
import guava.FuturesUtil;
import guava.ReturnEntity;
import guava.ThreadPoolManager;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * FuturesUtilTest
 *
 * @author luobosi@2dfire.com
 * @since 2018-05-02
 */
public class FuturesUtilTest {

    private ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
    private ListenableFuture<ReturnEntity> future1;
    private String future1Result = "test1";
    private ListenableFuture<ReturnEntity> future2;
    private String future2Result = "test2";
    private ListenableFuture<ReturnEntity> future3;
    private String future3Result = "test3";
    private ListenableFuture<ReturnEntity> future4;

    @Before
    public void before() throws Exception {
        future1 = service.submit(AsynTask.newTask("test asynTask 1").registExecute(() -> {
            Thread.sleep(1000);
            return "test1";
        }));
        future2 = service.submit(AsynTask.newTask("test asynTask 2").registExecute(() -> {
            Thread.sleep(2000);
            return "test2";
        }));
        future3 = service.submit(AsynTask.newTask("test asynTask 3").registExecute(() -> "test3"));
        future4 = service.submit(AsynTask.newTask("test asynTask 4").registExecute(() -> null));
    }

    @After
    public void after() throws Exception {
        service.shutdown();
    }


//    @Test
//    public void testAsList() throws Exception {
//        MatcherAssert.assertThat(Futures.successfulAsList(), Matchers.nullValue());
//        MatcherAssert.assertThat(Futures.successfulAsList(null,null), Matchers.nullValue());
//        MatcherAssert.assertThat(FuturesUtil.asList(null,null,future1).get().size(), Matchers.is(1));
//        MatcherAssert.assertThat(FuturesUtil.asList(null,null,future1,future2).get().size(), Matchers.is(2));
//        MatcherAssert.assertThat(FuturesUtil.asList(null,null,future1,future2,future3).get().size(), Matchers.is(3));
//    }

    /**
     * Method: handleWithOneReturn(ListenableFuture<List<ReturnEntity>> allFutures, long timeout, TimeUnit unit)
     */
    @Test
    public void testHandleWithOneReturn() throws Exception {
        ListenableFuture<List<ReturnEntity>> allFutures = Futures.successfulAsList(future1, future2);
        String res = FuturesUtil.handleWithOneReturn(allFutures, 2000, TimeUnit.MILLISECONDS);
        MatcherAssert.assertThat(res, Matchers.equalTo(future1Result));
    }

    /**
     * Method: handleWithAllReturn(ListenableFuture<List<ReturnEntity>> allFutures, long timeout, TimeUnit unit)
     */
    @Test
    public void testHandleWithAllReturn() throws Exception {
        ListenableFuture<List<ReturnEntity>> allFutures = Futures.successfulAsList(future1, future2, future3, future4);
        List<ReturnEntity> res = FuturesUtil.handleWithAllReturn(allFutures, 2000, TimeUnit.MILLISECONDS);
        MatcherAssert.assertThat(res.size(), Matchers.is(4));
        MatcherAssert.assertThat(res.get(0).getResult(), Matchers.equalTo(future1Result));
        MatcherAssert.assertThat(res.get(1).getResult(), Matchers.equalTo(future2Result));
        MatcherAssert.assertThat(res.get(2).getResult(), Matchers.equalTo(future3Result));
        MatcherAssert.assertThat(res.get(3).getResult(), Matchers.nullValue());
    }

    /**
     * Method: handleWithOutReturn(ListenableFuture<List<ReturnEntity>> allFutures, long timeout, TimeUnit unit)
     */
    @Test
    public void testHandleWithOutReturn() throws Exception {

    }

    /**
     * Method: fetch(List<ReturnEntity> returnEntityList, int index, int allCount)
     */
    @Test
    public void testFetch() throws Exception {
        ListenableFuture<List<ReturnEntity>> allFutures = Futures.successfulAsList(future1, future2, future3, future4);
        List<ReturnEntity> res = FuturesUtil.handleWithAllReturn(allFutures, 2000, TimeUnit.MILLISECONDS);
        MatcherAssert.assertThat(res.size(), Matchers.equalTo(4));
        String res1 = FuturesUtil.fetch(res, 0, 4);
        String res2 = FuturesUtil.fetch(res, 1, 4);
        String res3 = FuturesUtil.fetch(res, 2, 4);
        String res4 = FuturesUtil.fetch(res, 3, 4);
        MatcherAssert.assertThat(res1, Matchers.equalTo(future1Result));
        MatcherAssert.assertThat(res2, Matchers.equalTo(future2Result));
        MatcherAssert.assertThat(res3, Matchers.equalTo(future3Result));
        MatcherAssert.assertThat(res4, Matchers.nullValue());
    }

    /**
     * Method: cancel(ListenableFuture<List<ReturnEntity>> allFutures)
     */
    @Test
    public void testCancel() throws Exception {
        ThreadPoolManager threadPoolManager = ThreadPoolManager.INSTANCE;
        for (int i = 0; i < 1000; i++) {
            ListenableFuture<ReturnEntity> future1 = threadPoolManager.addExecuteTask(AsynTask.newTask("test asynTask 1").registExecute(() -> testPrint1()));
            System.out.println(future1);
        }
    }


    private static int i = 1;

    private static List<String> testPrint1() throws Exception {
        System.out.println("---------->cccccc" + i++);
        System.out.println(Runtime.getRuntime().availableProcessors());
        Thread.sleep(3000);
        return Lists.newArrayList("test print result 1", "22222");
    }


}
