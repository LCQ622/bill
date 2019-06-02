package cn.mcandoird.service;

import cn.mcandoird.page.Page;

import java.io.IOException;

public interface PageService {
    public Page showPage(int start,int size) throws IOException;
}
