import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.TemperatureSensorLog;
import java.util.List;

public interface TemperatureSensorLogRepository extends JpaRepository<TemperatureSensorLog, Long> {

    @Query("SELECT t FROM TemperatureSensorLog t WHERE t.shipment.id = :shipmentId")
    List<TemperatureSensorLog> findByShipmentId(@Param("shipmentId") Long shipmentId);
}