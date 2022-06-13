package metier;

import dao.IDao;

public class Metier implements IMetier{
    private IDao dao;  
	@Override
	public double calcul() {
		double t=dao.getTemprtature();
		return t*7;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	

}
