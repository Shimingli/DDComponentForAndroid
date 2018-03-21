package com.luojilab.reader;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.luojilab.componentservice.share.bean.Author;


/**
 * Created by mrzhang on 2017/6/15.
 */

public class ReaderFragment extends Fragment {

    private View rootView;

    private final static int REQUEST_CODE = 7777;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.readerbook_fragment_reader, container,
                    false);

            rootView.findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    goToShareActivityNormal();
                }
            });
            rootView.findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    goToShareActivityForResult();
                }
            });

        }
        return rootView;
    }

    private void goToShareActivityNormal() {
        Author author = new Author();
        author.setName("shiming 你爹");
        author.setCounty("中国");
        ARouter.getInstance().build("/share/shareBook")
                .withString("bookName", "我是Arouter 上跳转过来的")
                .withObject("author", author)
                .navigation();
    }


    //startActivityForResult
    private void goToShareActivityForResult() {
        Author author = new Author();
        author.setName("老婆");
        author.setCounty("台湾");
        ARouter.getInstance().build("/share/shareMagazine")
                .withString("bookName", "我是Arouter上的跳转过来")
                .withObject("author", author)
                .navigation(getActivity(), REQUEST_CODE);
    }

}
