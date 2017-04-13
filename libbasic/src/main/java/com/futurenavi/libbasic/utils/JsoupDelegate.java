package com.futurenavi.libbasic.utils;

/**
 * Created by pf on 16/12/15.
 */

public class JsoupDelegate {
//    private long start, end;
//    private ArticleTabDao mArticleDao;
//    private FunnyTextTabDao mFunnyDao;
//    private Document doc;
//
//    public JsoupDelegate(Object obj) {
//        if (obj instanceof ArticleTabDao) {
//            mArticleDao = (ArticleTabDao) obj;
//        }
//        if (obj instanceof FunnyTextTabDao) {
//            mFunnyDao = (FunnyTextTabDao) obj;
//        }
//    }
//
//
//
//
//    /**
//     * getHtmlAriticle 获取经典美文
//     */
//    private String articeleUrl = "http://meiwen.59xihuan.cn";
//    private String articeleDUrl = "http://meiwen.59xihuan.cn";
//    //http://meiwen.59xihuan.cn/index_2.html
//    public void getHtmlAriticle(int type) {
//        if(type>0){
//            articeleUrl=articeleUrl+"/index_"+type+".html";
//
//            Log.i("WZK", "getHtmlAriticle url:" + articeleUrl);
//            getHtmlAriticle();
//        }
//    }
//    public void getHtmlAriticle() {
//        start = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    doc = Jsoup.parse(new URL(articeleUrl), 5000);
////                    int es = doc.getElementsByClass("mixed1").size();
//                    Elements elements = doc.getElementsByClass("mixed1");
//                    for (int i = 0; i < elements.size(); i++) {
//                        Elements aTabs = elements.get(i).getElementsByTag("a");
//                        Elements pTabs = elements.get(i).getElementsByTag("p");
//                        Elements imgTabs = elements.get(i).getElementsByTag("img");
//                        Elements timeTabs = elements.get(i).getElementsByClass("time");
//
//
//                        for (int j = 0; j < aTabs.size(); j++) {
//                            String link = aTabs.get(j).attr("href");
//                            String title = aTabs.get(j).text();
//                            String des = pTabs.get(j).text();
//                            String samllImg = imgTabs.get(j).attr("smallImageSrc");
//                            String bigImg = imgTabs.get(j).attr("bigImageSrc");
//                            String time = timeTabs.get(j).text();
//                            String linkKey = EncryptUtils.encryptMD5ToString(link);
//
//                            link = articeleDUrl + link;
//                            samllImg = articeleDUrl + samllImg;
//                            bigImg = articeleDUrl + bigImg;
//                            ArticleTab article = new ArticleTab(linkKey
//                                    , samllImg, bigImg, title, time, des, link);
//
//
////                            Log.i("WZK",
////                                    "getHtmlAriticle \nlinkKey:" + linkKey +
////                                            "\nsamllImg:" + samllImg +
////                                            "\nbigImg:" + bigImg +
////                                            "\ntitle:" + title +
////                                            "\ntime:" + time +
////                                            "\ndes:" + des +
////                                            "\nlink:" + link);
//                            if (mArticleDao != null) {
//                                mArticleDao.insertOrReplace(article);
//                            }
//                        }
//                    }
//                    end = System.currentTimeMillis();
//                    Log.i("WZK", "getHtmlAriticle 爬虫+数据库插入-->耗时" + (end - start));
//                } catch (Exception e1) {
//                    Log.i("WZK", "getHtmlAriticle catch:" + e1.toString());
//                }
//            }
//        }).start();
//    }
//
//    /////////////////////////////////////以上为//////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    /////////////////////////////////////以下为获取美图//////////////////////////////////////
//
//    private String sexyImgUrl3 = "http://www.27270.com/tag/651.html";
//
//    public void getHtmlSexyImg3() {
//        start = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    doc = Jsoup.parse(new URL(sexyImgUrl3), 5000);
//
//
//                    Elements elements = doc.getElementsByClass("hr10");
//                    int es = elements.size();
//                    Log.i("WZK", "getHtmlSexyImg3 content:" + es);
//
//                    elements = doc.getElementsByClass("hr5");
//                    es = elements.size();
//                    Log.i("WZK", "getHtmlSexyImg3 content:" + es);
//
//                    elements = doc.getElementsByClass("w1200");
//                    es = elements.size();
//                    Log.i("WZK", "getHtmlSexyImg3 content:" + es);
//
//                    end = System.currentTimeMillis();
//                    Log.i("WZK", "getHtmlSexyImg 爬虫+数据库插入-->耗时" + (end - start));
//                } catch (Exception e1) {
//                    Log.i("WZK", "getHtmlSexyImg catch:" + e1.toString());
//                }
//            }
//        }).start();
//    }
//
//    /**
//     * getHtmlFunny
//     * http://www.gexing.com/shaitu/
//     * http://www.win4000.com/meinvtag34.html
//     * http://pic.yesky.com/c/6_20475.shtml#haosou
//     * http://www.mm131.com/xiaohua/
//     */
//    private String sexyImgUrl2 = "http://www.mm131.com/xiaohua/";
//
//    public void getHtmlSexyImg2() {
//        start = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    doc = Jsoup.parse(new URL(sexyImgUrl2), 5000);
//
//
//                    Elements elements = doc.getElementsByClass("toper");
//                    int es = elements.size();
//                    Log.i("WZK", "getHtmlSexyImg2 content:" + es);
//
//                    elements = doc.select("a href=");
//                    es = elements.size();
//                    Log.i("WZK", "getHtmlSexyImg2 content:" + es);
//
//                    elements = doc.getElementsByClass("nmark");
//                     es = elements.size();
//                    Log.i("WZK", "getHtmlSexyImg2 content:" + es);
//
//
//
////                    for (int i = 0; i < elements.size(); i++) {
////
////                        Elements aTabs = elements.get(i).getElementsByTag("img");
////                        for (int j = 0; j < aTabs.size(); j++) {
////                            String link = aTabs.get(j).attr("src");//alt
////                            String alt = aTabs.get(j).attr("alt");
////                            if (!TextUtils.isEmpty(elements.get(i).text())) {
//////                                FunnyTab funny = new FunnyTab(null, alt, link);
//////                                if (mFunnyDao != null) {
//////                                    mFunnyDao.insertOrReplace(funny);
//////                                }
////                            }
////
////                        }
////                    }
//                    end = System.currentTimeMillis();
//                    Log.i("WZK", "getHtmlSexyImg 爬虫+数据库插入-->耗时" + (end - start));
//                } catch (Exception e1) {
//                    Log.i("WZK", "getHtmlSexyImg catch:" + e1.toString());
//                }
//            }
//        }).start();
//    }
//    /**
//     * getHtmlFunny 获取糗百妹图片
//     */
//    private String sexyImgUrl = "http://www.qiubaichengren.com/";
//
//    public void getHtmlSexyImg() {
//        start = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    doc = Jsoup.parse(new URL(sexyImgUrl), 5000);
//
//
//                    Elements elements = doc.getElementsByClass("mala-text");
//                    int es = elements.size();
////                    Log.i("WZK", "getHtmlFunny content:" + es);
//                    for (int i = 0; i < elements.size(); i++) {
//
//                        Elements aTabs = elements.get(i).getElementsByTag("img");
//                        for (int j = 0; j < aTabs.size(); j++) {
//                            String link = aTabs.get(j).attr("src");//alt
//                            String alt = aTabs.get(j).attr("alt");
//                            if (!TextUtils.isEmpty(elements.get(i).text())) {
////                                FunnyTab funny = new FunnyTab(null, alt, link);
////                                if (mFunnyDao != null) {
////                                    mFunnyDao.insertOrReplace(funny);
////                                }
//                            }
//
//                        }
//                    }
//                    end = System.currentTimeMillis();
//                    Log.i("WZK", "getHtmlSexyImg 爬虫+数据库插入-->耗时" + (end - start));
//                } catch (Exception e1) {
//                    Log.i("WZK", "getHtmlSexyImg catch:" + e1.toString());
//                }
//            }
//        }).start();
//    }
//
//    /////////////////////////////////////以上为//////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    /////////////////////////////////////以下为获取段子//////////////////////////////////////
//
////    http://www.yidianzixun.com/home?page=channel&keyword=%E6%AE%B5%E5%AD%90
//
//    /**
//     * getHtmlFunny 获取搞笑段子
//     */
//    private String funnyUrl2 = "http://www.budejie.com/text/";
//
//    private String funnyDUrl2 = "http://www.budejie.com";
//    //http://meiwen.59xihuan.cn/index_2.html
//    public void getHtmlFunny2(int type) {
//        if(type>0){
//            funnyUrl2=funnyUrl2+type;
//
//            Log.i("WZK", "getHtmlFunny2 url:" + funnyUrl2);
//            getHtmlAriticle();
//        }
//    }
//
//    public void getHtmlFunny2() {
//        start = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    doc = Jsoup.parse(new URL(funnyUrl2 ), 5000);
//
//                    Elements elements = doc.getElementsByClass("u-img");
//                    int es = elements.size();
//                    Elements elements2 = doc.getElementsByClass("j-r-list-c-desc");
//                    es = elements.size();
////                    Log.i("WZK", "getHtmlFunny2 size " + es);
//                    for (int i = 0; i < elements.size(); i++) {
//                        Elements imgTabs = elements.get(i).getElementsByTag("img");
//
//                        Elements aTabs = elements2.get(i).getElementsByTag("a");
//                        if (imgTabs.size() >= aTabs.size()) {
//                            for (int j = 0; j < imgTabs.size(); j++) {
//                                String linkImg = imgTabs.get(j).attr("data-original");
//                                String name = imgTabs.get(j).attr("alt");
//                                String desLink = aTabs.get(j).attr("href");
//                                String content = aTabs.get(j).text();
//                                desLink = funnyDUrl2 + desLink;
//                                String linkKey = EncryptUtils.encryptMD5ToString(linkImg);
//
////                                Log.i("WZK", "getHtmlFunny2 linkImg " + linkImg);
////                                Log.i("WZK", "getHtmlFunny2 name " + name);
////                                Log.i("WZK", "getHtmlFunny2 href " + desLink);
////                                Log.i("WZK", "getHtmlFunny2 content " + content);
//                                FunnyTextTab funny = new FunnyTextTab(linkKey, linkImg, name,
//                                        desLink, content);
//                                if (mFunnyDao != null) {
//                                    mFunnyDao.insertOrReplace(funny);
//                                }
////                            }
//                            }
//                        }
//
//
//                        if (!TextUtils.isEmpty(elements.get(i).text())) {
////                            // TODO: 16/12/15 link字段必须为null 方为文字
////
////                            String des =elements.get(i).html();
////                            if (des.contains("更多") || des.contains("东北特产")) {
////                                break;
////                            }
////                            des= des.replaceAll("<p>","");
////                            des= des.replaceAll("</p>","");
////                            FunnyTab funny = new FunnyTab(null, des, null);
////                            if (mFunnyDao != null) {
////                                mFunnyDao.insertOrReplace(funny);
////                            }
//                        }
//                    }
//
//                    end = System.currentTimeMillis();
//                    Log.i("WZK", "getHtmlFunny2 爬虫+数据库插入-->耗时" + (end - start));
//                } catch (Exception e1) {
//                    Log.i("WZK", "getHtmlFunny2 catch:" + e1.toString());
//                }
//            }
//        }).start();
//    }
//
//
//
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    ///////////////////////////////////////////////////////////////////////////////////////////
//    /////////////////////////////////////以下为获取段子//////////////////////////////////////
//
//    /**
//     * getHtmlFunny 获取搞笑段子
//     */
//    private String tempUrl = "http://www.xiaoliaobaike.cn/";
//
//    public void useHTML() {
//        start = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    doc = Jsoup.parse(new URL(funnyUrl), 5000);
//
//                    Elements elements = doc.getElementsByClass("content");
//                    int es = elements.size();
//                    for (int i = 0; i < elements.size(); i++) {
//
//                    }
//
//                    end = System.currentTimeMillis();
//                    Log.i("WZK", "getHtmlFunny 爬虫+数据库插入-->耗时" + (end - start));
//                } catch (Exception e1) {
//                    Log.i("WZK", "getHtmlFunny catch:" + e1.toString());
//                }
//            }
//        }).start();
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//    /**
//     * getHtmlFunny 获取搞笑段子
//     */
//    private String funnyUrl = "http://www.xiaoliaobaike.cn/";
//
//    public void getHtmlFunny() {
//        start = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    doc = Jsoup.parse(new URL(funnyUrl), 5000);
//
//                    Elements elements = doc.getElementsByClass("content");
//                    int es = elements.size();
//                    for (int i = 0; i < elements.size(); i++) {
//
//                        if (!TextUtils.isEmpty(elements.get(i).text())) {
//                            // TODO: 16/12/15 link字段必须为null 方为文字
//
//                            String des = elements.get(i).html();
//                            if (des.contains("更多") || des.contains("东北特产")) {
//                                break;
//                            }
//                            des = des.replaceAll("<p>", "");
//                            des = des.replaceAll("</p>", "");
////                            FunnyTab funny = new FunnyTab(null, des, null);
////                            if (mFunnyDao != null) {
////                                mFunnyDao.insertOrReplace(funny);
////                            }
//                        }
//                    }
//
//                    end = System.currentTimeMillis();
//                    Log.i("WZK", "getHtmlFunny 爬虫+数据库插入-->耗时" + (end - start));
//                } catch (Exception e1) {
//                    Log.i("WZK", "getHtmlFunny catch:" + e1.toString());
//                }
//            }
//        }).start();
//    }

}
