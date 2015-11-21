package com.lp.dailyknowlodge.service;

import com.lp.dailyknowlodge.domain.Share;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linpeng123l on 2015/11/18.
 */
public class ShareService extends BaseService{

    public static void publishShare(Share share,MsgResultCallback msgResultCallback){
      /*  try {
//            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        postSuccess(msgResultCallback,"恭喜您操作成功");
    }

    public static void queryMyShares(ShareResultCallback shareResultCallback){
        List<Share> shares = new ArrayList<>();
        Share share = new Share();
        share.setSubject("达芬奇睡眠");
        share.setIsAdopt(1);
        share.setAward(100);
        shares.add(share);
        shares.add(share);
        shares.add(share);
        shares.add(share);
        postSuccess(shareResultCallback,shares);
    }

    public interface ShareResultCallback extends ResultCallback<List<Share>>{
    }

}
