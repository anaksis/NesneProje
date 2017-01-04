import static org.junit.Assert.*;
import org.junit.Test;

public class MyMakaleTest {
	
	@Test
	public void testBirlestirme() {
        Makale unit = new Makale("1","Baslýk","yazar","venue",2017,"icerik");
 
        String sonuc = unit.idTileBirlestir();
        assertEquals(unit.getId()+unit.getTitle(),sonuc);
        
 
    }

}
