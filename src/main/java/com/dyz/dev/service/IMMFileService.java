package com.dyz.dev.service;
import com.dyz.dev.model.IMMFile;
import com.dyz.dev.model.Supplier;
import com.dyz.dev.utils.Service;

import java.io.File;


/**
 * Created by dyz on 2019/12/23.
 */
public interface IMMFileService extends Service<IMMFile> {
    public String saveFile(File file, String formNo);
    public String updateIMMFileFormNo(String oldFormNo, String newFormNo);
}
