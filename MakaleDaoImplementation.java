import java.util.ArrayList;
import java.util.List;

public class MakaleDaoImplementation implements MakaleDao {
	
	List<Makale> makaleler;
	
	public MakaleDaoImplementation(){
		makaleler = new ArrayList<Makale>();
			
		//Örnek makale bilgileri
		Makale makale1 = new Makale("304248","Versions and workspaces in Microsoft repository","Thomas Bergstraesser, Philip A. Bernstein, Shankar Pal, David Shutt","International Conference on Management of Data",1999,null);
		Makale makale2 = new Makale("304570","An XJML-based wrapper generator for Web information extraction","Ling Liu, Wei Han, David Buttler, Calton Pu, Wei Tang","International Conference on Management of Data",1999,null);
		Makale makale3 = new Makale("304571","DBIS-toolkit: adaptable middleware for large scale data delivery","Mehmet Altinel, Demet Aksoy, Thomas Baby, Michael Franklin, William Shapiro, Stan Zdonik","International Conference on Management of Data",1999,null);
		Makale makale4 = new Makale("304573","Database patchwork on the Internet","Reinhard Braumandl, Alfons Kemper, Donald Kossmann","International Conference on Management of Data",1999,null);
		Makale makale5 = new Makale("304582","The CCUBE constraint object-oriented database system","Alexander Brodsky, Victor E. Segal, Jia Chen, Paval A. Exarkhopoulo","International Conference on Management of Data",1999,null);
		Makale makale6 = new Makale("304583","The Cornell Jaguar project: adding mobility to PREDATOR","Phillippe Bonnet, Kyle Buza, Zhiyuan Chan, Victor Cheng, Randolph Chung, Takako Hickey, Ryan Kennedy, Daniel Mahashin, Tobias Mayr, Ivan Oprencak, Praveen Seshadri, Hubert Siu","International Conference on Management of Data",1999,null);
		Makale makale7 = new Makale("304584","The active MultiSync controller of the cubetree storage organization","Nick Roussopoulos, Yannis Kotidis, Yannis Sismanis","International Conference on Management of Data",1999,null);
		Makale makale8 = new Makale("304587","A user-centered interface for querying distributed multimedia databases","Isabel F. Cruz, Kimberly M. James","International Conference on Management of Data",1999,null);
		Makale makale9 = new Makale("304589","World Wide Database-integrating the Web, CORBA and databases","Athman Bouguettaya, Boualem Benatallah, Lily Hendra, James Beard, Kevin Smith, Mourad Quzzani","International Conference on Management of Data",1999,null);
		Makale makale10 = new Makale("304590","XML-based information mediation with MIX","Chaitan Baru, Amarnath Gupta, Bertram Lud&#228	scher, Richard Marciano, Yannis Papakonstantinou, Pavel Velikhov, Vincent Chu","International Conference on Management of Data",1999,null);
		
		//makaleler listeye ekleniyor
		makaleler.add(makale1);
		makaleler.add(makale2);
		makaleler.add(makale3);
		makaleler.add(makale4);
		makaleler.add(makale5);
		makaleler.add(makale6);
		makaleler.add(makale7);
		makaleler.add(makale8);
		makaleler.add(makale9);
		makaleler.add(makale10);
	  
	}
	   
	public List<Makale> getAllMakale() {
		return makaleler;
	}
	   
	public Makale getMakale(int index) {
		return makaleler.get(index);
	}

	@Override
	public void deleteMakale(Makale makale) {
		// TODO Auto-generated method stub
		
	}


}
