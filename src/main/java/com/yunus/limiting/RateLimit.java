package com.yunus.limiting;

/**
 * @author gaoyunfeng
 * @Description:
 * @date 2020/7/816:37
 */
public interface RateLimit {

    /**
     * 当前流量是否能通过
     *
     * @return true 可以通过  false 不可以通过
     * @throws BlockException
     */
    boolean canPass() throws BlockException;
}
