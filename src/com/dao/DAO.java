package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	public static Connection connect() throws SQLException {
		
		Connection cnn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/thionline", "root", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return cnn;
	}
	
	public static boolean ktsinhvien(String username, String pass){
		
		Statement stm=null;
		ResultSet rs=null;
		boolean tmp=false;
		
		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			rs=stm.executeQuery("select * from sinhvien where user='"+username+"' and pass='"+pass+"'");
			tmp=rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tmp;
	}

	public static boolean ktgiangvien(String username, String pass){

		Statement stm=null;
		ResultSet rs=null;
		boolean tmp=false;

		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			rs=stm.executeQuery("select * from giangvien where user='"+username+"' and pass='"+pass+"'");
			tmp=rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tmp;
	}

	public static boolean ktadmin(String username, String pass){

		Statement stm=null;
		ResultSet rs=null;
		boolean tmp=false;

		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			rs=stm.executeQuery("select * from admin where user='"+username+"' and pass='"+pass+"'");
			tmp=rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tmp;
	}

	public static int layidsv(String username){

		Statement stm=null;
		ResultSet rs=null;
		int id =-1;

		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			rs=stm.executeQuery("select * from sinhvien where user='"+username+"'");
			while(rs.next())
			{
				id=Integer.parseInt(rs.getString(1));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return id;
	}
	
	public static int layidgv(String username){

		Statement stm=null;
		ResultSet rs=null;
		int id =-1;

		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			rs=stm.executeQuery("select * from giangvien where user='"+username+"'");
			while(rs.next())
			{
				id=Integer.parseInt(rs.getString(1));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return id;
	}
	
	public static int layidlop(String username){

		Statement stm=null;
		ResultSet rs=null;
		int id =-1;

		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			rs=stm.executeQuery("select * from sinhvien where user='"+username+"'");
			while(rs.next())
			{
				id=Integer.parseInt(rs.getString(4));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;
	}

	public static void addbailamsv(int idsinhvien, int idde,int idcaunew,int dapan){
		
		Statement stm=null;
		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			stm.executeUpdate("insert into bailam (idsinhvien,idde,idcaunew,dapan) values('"+idsinhvien+"','"+idde+"','"+idcaunew+"','"+dapan+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static int ThemChuDeThaoLuan(String tenchude) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into chude (tenchude) values('"+tenchude+"')");
		
		return i;
	}

	public static void luuketqua(int idsinhvien, int idde,int diem){
		Statement stm=null;
		try {
			Connection cnn=connect();
			stm=cnn.createStatement();
			stm.executeUpdate("insert into ketqua (idsinhvien,idde,diem) values('"+idsinhvien+"','"+idde+"','"+diem+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static int AddDe(String tende, String ngaytao) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into de (tende, ngaytao) values('"+tende+"','"+ngaytao+"')");
		
		return i;
	}
	
	public static int Addgiaobai(int idde, int idlop, String thoigianhethan) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into giaobai (idde, idlop,thoigianhethan) values('"+idde+"','"+idlop+"','"+thoigianhethan+"')");
		
		return i;
	}
	
	public static int DeleteGaioBai(String idde, String idlop, String thoigian) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("DELETE FROM giaobai WHERE idde='"+idde+"' and idlop='"+idlop+"' and thoigianhethan='"+thoigian+"'");
		
		return i;
	}
	
	public static int SuaSinhVien(String user, String pass, String idlop, String idsinhvien) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("UPDATE sinhvien SET user='"+user+"',pass='"+pass+"',idlop='"+idlop+"' WHERE idsinhvien="+idsinhvien);
		
		return i;
	}
	
	public static int SuaPassSinhVien(String pass,int idsinhvien) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("UPDATE sinhvien SET pass='"+pass+"' WHERE idsinhvien="+idsinhvien);
		
		return i;
	}
	
	public static int SuaPassGiangVien(String pass,int id) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("UPDATE giangvien SET pass='"+pass+"' WHERE idgiangvien="+id);
		
		return i;
	}
	
	public static int ThemCau(int idde,String c1,String c1a,String c1b,String c1c,String c1d,int A1,int B1,int C1,int D1) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into caunew (idde,noidung,A,B,C,D,A1,B1,C1,D1) values('"+idde+"','"+c1+"','"+c1a+"','"+c1b+"','"+c1c+"','"+c1d+"','"+A1+"','"+B1+"','"+C1+"','"+D1+"')");
		
		return i;
	}
	
	public static int ThemGiangVien(String user,String pass) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into giangvien (user, pass) values('"+user+"','"+pass+"')");
		
		return i;
	}
	
	public static int ThemSinhVien(String user,String pass, String idlop) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into sinhvien (user, pass,idlop) values('"+user+"','"+pass+"','"+idlop+"')");
		
		return i;
	}
	
	public static int ThemLop(String tenlop) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into lop (tenlop) values('"+tenlop+"')");
		
		return i;
	}
	
	public static int ThemNoiDungVaoThaoLuan(String idchude,String noidung) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("insert into noidungthaoluan (idchude,noidung) values('"+idchude+"','"+noidung+"')");
		
		return i;
	}
	
	public static ResultSet bangbailam(int idsv,int idde) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet bangbailam = stm.executeQuery("select * from bailam where idsinhvien='"+idsv+"' and idde='"+idde+"'");
		
		return bangbailam;
	}
	
	public static ResultSet bangchude() throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet bangchude = stm.executeQuery("select * from chude");
		
		return bangchude;
	}
	
	public static ResultSet laynoidungtheoidchude(String idchude) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet laynoidungtheoidchude = stm.executeQuery("select * from noidungthaoluan where idchude='"+idchude+"'");
		
		return laynoidungtheoidchude;
	}
	
	public static ResultSet dapandung(int i) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet dapandung = stm.executeQuery("select * from caunew where idcaunew='"+i+"'");
		
		return dapandung;
	}
	
	public static int XoaDe(String id) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("DELETE FROM de WHERE idde=" + id);
		
		return i;
	}
	
	public static int XoaCau(String id) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("DELETE FROM caunew WHERE idde=" + id);
		
		return i;
	}
	
	public static ResultSet bangcau(String id) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet bangcau = stm.executeQuery("select * from caunew where idcaunew='"+id+"'");
		
		return bangcau;
	}
	
	public static ResultSet bangcautheode(String idde) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet bangcau = stm.executeQuery("select * from caunew where idde='"+idde+"'");
		
		return bangcau;
	}
	
	public static int XoaLop(String idlop) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("DELETE FROM lop WHERE idlop=" + idlop);
		
		return i;
	}
	
	public static int XoaSinhVien(String idsinhvien) throws SQLException{

		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		int i = stm.executeUpdate("DELETE FROM sinhvien WHERE idsinhvien=" + idsinhvien);
		
		return i;
	}
	
	public static ResultSet giaobaivoilop() throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet giaobaivoilop = stm.executeQuery("select * from giaobai,lop where giaobai.idlop=lop.idlop");
		
		return giaobaivoilop;
	}
	
	public static ResultSet bangde() throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet bangde = stm.executeQuery("select * from de");
		
		return bangde;
	}
	
	public static ResultSet banglop() throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet banglop = stm.executeQuery("select * from lop");
		
		return banglop;
	}
	
	public static ResultSet giaobaitheolop(int idlop) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet giaobaitheolop = stm.executeQuery("SELECT * FROM giaobai,de where giaobai.idde=de.idde and giaobai.idlop='"+idlop+"'");
		
		return giaobaitheolop;
	}
	
	public static ResultSet bangbailamtheosinhvien(int idsv,int idde) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet bangbailamtheosinhvien = stm.executeQuery("select * from bailam where idsinhvien='"+ idsv + "' and idde='" + idde + "'");
		
		return bangbailamtheosinhvien;
	}
	
	public static ResultSet sinhvientheolop() throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet sinhvientheolop = stm.executeQuery("SELECT * FROM sinhvien, lop where sinhvien.idlop=lop.idlop");
		
		return sinhvientheolop;
	}
	
	public static ResultSet giangvientheoten(String name) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet giangvientheoten = stm.executeQuery("select * from giangvien where user='"+name+"'");
		
		return giangvientheoten;
	}
	
	public static ResultSet sinhvientheoten(String name) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet sinhvientheoten = stm.executeQuery("select * from sinhvien where user='"+name+"'");
		
		return sinhvientheoten;
	}
	
	public static ResultSet tatcagiangvien() throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet tatcagiangvien = stm.executeQuery("select * from giangvien");
		
		return tatcagiangvien;
	}
	
	public static ResultSet ketquatheohocsinh(int idsinhvien) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet ketquatheohocsinh = stm.executeQuery("select * from ketqua where idsinhvien='"+idsinhvien+"'");
		
		return ketquatheohocsinh;
	}
	
	public static ResultSet sinhviennoiloptheoten(String name) throws SQLException{
		
		Statement stm=null;
		Connection cnn=connect();
		stm=cnn.createStatement();
		ResultSet sinhviennoiloptheoten = stm.executeQuery("SELECT * FROM sinhvien,lop where sinhvien.idlop=lop.idlop and sinhvien.user='"+name+"'");
		
		return sinhviennoiloptheoten;
	}



}
