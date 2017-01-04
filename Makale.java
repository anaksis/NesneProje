

public class Makale	 {
	
	private String id;
	private String title;
	private String authors;
	private String venue;
	private String icerik;
	private int year;
	private String idtitle;
		
	public Makale(String trim, String trim2, String trim3, String trim4, int parseInt,String icerik) {
	
		this.setId(trim);
		this.setTitle(trim2);
		this.setAuthors(trim3);
		this.setVenue(trim4);
		this.setYear(parseInt);
		this.setIcerik(icerik);
	}

	public String idTileBirlestir()
	{
		String kelime;
		return kelime=getId()+getTitle();
	}
	
	public String getidtitle() {
		return idtitle;
	}

	public void setidtitle(String idtitle) {
		this.idtitle = idtitle;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
				/**
				 * @return the authors
				 */
	public String getAuthors() {
		return authors;
	}
				/**
				 * @param authors the authors to set
				 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public String getIcerik() {
		return icerik;
	}
	
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public void setVenue(String venue) {
		this.venue = venue;
	}
				
	@Override
	public String toString(){
		return getId()+"--"+getTitle()+"--"+getAuthors()+"--"
			+getVenue()+"--"+getYear()+"--"+getIcerik();				
	}




}
