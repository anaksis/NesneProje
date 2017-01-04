import java.util.List;

public interface MakaleDao {

	public List<Makale> getAllMakale(); // Tüm makaleleri return eder
	public void deleteMakale(Makale makale); // bir makaleyi silmeye yarar
	
}
