package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.Metier;

public class Presentation {
	
	public static void main(String[] args) {
//	    DaoImpl dao = new DaoImpl();
//      Metier m = new Metier();
//      m.setDao(dao);
//      System.out.println(m.calcul());
		try {
			Scanner scanner = new Scanner(new File("config.txt"));
			String daoClassName = scanner.next();
			String metierClassName = scanner.next();
			Class cDao = Class.forName(daoClassName);
			Class cMetier = Class.forName(metierClassName);
			IDao dao = (IDao) cDao.newInstance();
			IMetier m = (IMetier) cMetier.newInstance();
			Method method = cMetier.getMethod("setDao", new Class[] {IDao.class});
			method.invoke(m, new Object[] {dao});
			System.out.println(m.calcul());
			System.out.println(dao.getTemprtature());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
