package com.vedio.inter;


import java.util.ArrayList;

import com.vedio.dao.VedioDAO;

public interface VedioInterface {
	public String upload(VedioDAO vedio);
	public String delete(ArrayList<VedioDAO> arr);
	public String check(VedioDAO vedio);
	public String getName(VedioDAO vedio);
	public ArrayList<String> getName();
	public ArrayList<VedioDAO> getNameList();
}
