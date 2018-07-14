package com.example.knutt.myproject;

import java.util.ArrayList;

public class Paginator {


    public static final int TOTAL_NUM_ITEM= 16 ;
    public static final int ITEM_PER_PAGE= 4;
    public static final int ITEM_REMAINING=TOTAL_NUM_ITEM%ITEM_PER_PAGE ;
    public static final int LAST_PAGE =TOTAL_NUM_ITEM/ITEM_PER_PAGE ;

    public ArrayList<String> generatePage(int currentPage){
        int startItem=currentPage*ITEM_PER_PAGE+1;
        int numOfDate = ITEM_PER_PAGE;

        ArrayList<String> pageData = new ArrayList<>();

        if(currentPage == LAST_PAGE && ITEM_REMAINING > 0){
            for(int i= startItem;i<startItem+ITEM_REMAINING;i++){
                pageData.add("Number  "+i);
            }

        }else{
            for(int i= startItem;i<startItem+numOfDate  ;i++){
                pageData.add("Number  "+i);
            }

        }
        return pageData;
    }
}
