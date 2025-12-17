@RestController
@RequestMapping("/api/shipments")
public class ShipmentRecordController{
    @Autowired 
    ShipmentRecordService shipmentrecordservice;

    @PostMapping
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment){
        return shipmentrecordservice.createShipment(shipment);
    }

    @PutMapping
    public ShipmentRecord updateStatus(@PathVariable Long id,String status){
        return shipmentrecordservice.updateShipmentStatus(id,status);
    }
    
    @GetMapping("/code/{shipmentCode}")
    public ShipmentRecord getByCode(@PathVariable String shipmentCode){
        return shipmentrecordservice.getShipmentByCode
    }

}