import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

import com.mongodb.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {
		
		Scanner input = new Scanner(System.in);
	    MakaleDao makaledao = new MakaleDaoImplementation();
	    PdfOku pdfoku = new PdfOku();
	    
	    ArrayList<Makale> MakaleList = new FileOperator().extracted("resource/ACM.csv");
		/*for (Makale publication1 : MakaleList){
			System.out.println(publication1);
		}*/
		
		for (Makale makale : makaledao.getAllMakale()) { // search all articles	
		    pdfoku.setFilePath("C:\\Users\\Enes\\workspace\\Deneme\\Pdf\\"+makale.getId()+".pdf");
		    makale.setIcerik(pdfoku.ToText());
		}
		
	    int cevap=0,cevap2=0,yil=0;
		
		menu();
		System.out.println("Yapmak Ýstediðiniz Ýþlemi Seçiniz:");
		cevap=input.nextInt();
		while(cevap!=7)
		{
			switch (cevap) {
			case 1://Pdf Ýndir
				PdfIndir(MakaleList);
				break;
			case 2://MangoDB aktar
				MangoDbAktar(makaledao);
				break;
			case 3://Yýla Göre makale
				System.out.println("Aramak Ýstedeðiniz Yýlý Giriniz:");
				yil=input.nextInt();
				YilaGoreMakaleAra(yil,MakaleList);
				break;
			case 4:
				System.out.println("Aramak Ýstedeðiniz Ýsmi Giriniz:");
				input.nextLine();
				String kelime=input.nextLine();
				IsmeGoreMakaleAra(kelime, MakaleList);
				break;
			case 5:
				System.out.println("Aramak Ýstedeðiniz Anahtar Kelimeyi Giriniz:");
				String kelime2=input.next();
				AnahtaraGoreMakaleAra(kelime2, makaledao);
				break;
			case 6:
				System.out.println("YDS->1 \nKPSS->2 \nALES->3");
				cevap2=input.nextInt();
				YaklasanSinav(cevap2);
				break;
			case 7://Çýkýþ
				System.out.println("By");
				input.close();
				break;
			}
			menu();
			System.out.println("Yapmak Ýstediðiniz Ýþlemi Seçiniz:");
			cevap=input.nextInt();
		}
		
}
	
	private static void KelimeSay()
	{
		
	}
	
	private static void YaklasanSinav(int numara) throws IOException
	{
		String kelime;
		Document doc;
		switch (numara) {
		case 1://YDS
			doc = Jsoup.connect("http://www.osym.gov.tr/TR,10197/2016.html").get();
			Elements links = doc.select("a[href]");
			for (Element link : links) {	
				if ( link.attr("href").contains("yds"))
					// get the value from href attribute
					System.out.println("text : " + link.text());
			}
			break;
		case 2://KPSS
			 doc = Jsoup.connect("http://www.osym.gov.tr/TR,10257/2016.html").get();		
	         Elements links2 = doc.select("a[href]");
	         for (Element link : links2) {	
	        	 {	
					if ( link.attr("href").contains("kpss"))
						System.out.println("text : " + link.text());						
	        	 }
	         }	
			break;
		case 3://ALES
			// need http protocol
			doc = Jsoup.connect("http://www.osym.gov.tr/TR,10208/2016.html").get();
			// get all links
			Elements links3 = doc.select("a[href]");
			for (Element link : links3) {
				if ( link.attr("href").contains("ales"))
				{
					// get the value from href attribute
					System.out.println("text : " + link.text());
					kelime = link.text();
				}
			}
			break;

		default:
			System.out.println("Geçersiz Giriþ!");
			break;
		}
	}
	
	private static void MangoDbAktar(MakaleDao makaledao)
	{
		try {
			 MongoClient mongoClient = new MongoClient("localhost", 27017);
			 
			 @SuppressWarnings("deprecation")
			 DB db = mongoClient.getDB("test");
			 DBCollection col = db.getCollection("Nesne3");
			 
			 for(Makale makale : makaledao.getAllMakale())
			 {
				 BasicDBObject doc = new BasicDBObject("Id",makale.getId()).
                        append("Title", makale.getTitle()).
                        append("Authors", makale.getAuthors()).
                        append("Venue", makale.getVenue()).
                        append("Year", makale.getYear()).
                        append("Icerik",makale.getIcerik());
				 
				 col.insert(doc);
			 }
			
			 DBCursor cursor = col.find();
            int i = 1;
   		
            // MongoDB ye attýðýmýz datalarý yazýyor
            while (cursor.hasNext()) { 
               System.out.println("Ekleme Kontrol: "+i); 
               System.out.println(cursor.next()); 
               i++;
            }
            mongoClient.close();
		} 
		catch (Exception e) {
			 System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	private static void menu()
	{
		System.out.println("1) --Pdf Ýndir--");
		System.out.println("2) --MangoDBye Aktar--");
		System.out.println("3) --Yýla Göre Makale Ara--");
		System.out.println("4) --Ýsime Göre Makale Ara--");
		System.out.println("5) --Anahtar Kelimeye Göre Makale Ara--");
		System.out.println("6) --Yaklaþan Sýnav Tarihleri--");
		System.out.println("7) --Çýkýþ--");
	}
	
	private static void YilaGoreMakaleAra(int yil,ArrayList<Makale> MakaleList)
	{
		boolean kontrol = false; // For the control we have article or not about year take from user

		for (int i=0;i<MakaleList.size();i++) { // search all articles
 	   
			if ( yil == MakaleList.get(i).getYear()) // if that article exists has that year ?
			{
				// print that articles or article
				System.out.println("MakaleId: [ ID : " + MakaleList.get(i).getId() + ", Title : " + MakaleList.get(i).getTitle() + ", Year " + yil + " ]");
				kontrol = true;	   
			}
		}
    
		if ( !(kontrol) )
			System.out.println(" Aradýðýnýz Yýla Ait Makale Bulunmamaktadýr! ");
	
	}//end yýla gore makale arama	
	
	private static void IsmeGoreMakaleAra(String isim,ArrayList<Makale> MakaleList)
	{
		boolean kontrol = false;
		for (int i=0;i<MakaleList.size();i++) { // search all articles
 	   
			if ( MakaleList.get(i).getTitle().contains(isim)) // if that article exists has that year ?
			{
				// print that articles or article
				System.out.println("MakaleId: [ ID : " + MakaleList.get(i).getId() + ", Title : " + MakaleList.get(i).getTitle() + ", Year " + MakaleList.get(i).getYear() + " ]");
				kontrol = true;	   
			}
		}
    
		if ( !(kontrol) )
			System.out.println(" Aradýðýnýz Baþlýðý Ýçeren Makale Bulunmamaktadýr ! ");
	}
	
	private static void AnahtaraGoreMakaleAra(String kelime,MakaleDao makaledao)
	{
		System.out.println("Bu fonksiyonun Halen Daha Üzerinde Çalýþýlýyor :) ");
	}
	
	private static void PdfIndir (ArrayList<Makale> MakaleList) throws InterruptedException
	{
		Random r =new Random ();
		int sayi=r.nextInt(2294);
		String id=MakaleList.get(sayi).getId();
		PdfDownload pdfdw =new PdfDownload();
		pdfdw.pdfindir(id);	
	}

}


	
  	


	

