@Override
public BreachRecord logBreach(BreachRecord breach) {
    if (breach.getShipment() == null || breach.getShipment().getId() == null) {
        throw new BadRequestException("Shipment ID must be provided");
    }
    
    // Logic: If the user passed just an ID, Hibernate handles it.
    // We set defaults if missing.
    if (breach.getDetectedAt() == null) breach.setDetectedAt(LocalDateTime.now());
    if (breach.getResolved() == null) breach.setResolved(false);
    
    return breachRecordRepository.save(breach); 
}