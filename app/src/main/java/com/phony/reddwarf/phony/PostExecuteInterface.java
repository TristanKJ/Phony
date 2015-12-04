package com.phony.reddwarf.phony;

/**
 * Created by RedDwarf on 12/3/2015.
 */
public interface PostExecuteInterface {

    void waitComplete();
    void failure(Exception e);

}
