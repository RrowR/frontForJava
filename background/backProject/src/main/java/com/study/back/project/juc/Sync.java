package com.study.back.project.juc;

import com.study.back.project.util.LoggerUtil;

import java.util.concurrent.*;

/**
 * @author: Rrow
 * @date: 2023/3/14 13:49
 * Description:
 */
public class Sync {
    static ExecutorService pool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        sync();
    }

    // 同步的方式
    private static void sync() throws InterruptedException, ExecutionException {
        String result = CompletableFuture.supplyAsync(() -> {
            LoggerUtil.get().debug("开始计算");
            sleep2s();
            LoggerUtil.get().debug("计算完成");
            return "mission complete";
        }, pool).get();
        LoggerUtil.get().debug(result);
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
