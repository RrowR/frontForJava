package com.study.back.project.juc;

import com.study.back.project.util.LoggerUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Rrow
 * @date: 2023/3/14 13:49
 * Description:
 */
public class Async {
    static ExecutorService pool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        aync();
    }

    // 异步的方式
    private static void aync() throws InterruptedException, ExecutionException {
        CompletableFuture.supplyAsync(() -> {
            LoggerUtil.get().debug("开始计算");
            sleep2s();
            LoggerUtil.get().debug("计算完成");
            return "mission complete";
        }, pool).thenAcceptAsync(result -> LoggerUtil.get().debug(result), pool);   // 以异步的方式来接收结果,这里接收的结果由另一个线程来处理
        LoggerUtil.get().debug("最后...");

    }

    private static void sleep2s() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
