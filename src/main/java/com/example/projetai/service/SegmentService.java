package com.example.projetai.service;

@Service
@RequiredArgsConstructor
public class SegmentService {

    private final SegmentRepository segmentRepository;

    // Récupérer tous les segments
    public List<Segment> getAllSegments() {
        return segmentRepository.findAll();
    }

    // Récupérer un segment par son ID
    public Optional<Segment> getSegmentById(Long id) {
        return segmentRepository.findById(id);
    }

    // Créer un nouveau segment
    public Segment createSegment(Segment segment) {
        return segmentRepository.save(segment);
    }

    // Mettre à jour un segment
    public Segment updateSegment(Long id, Segment updatedSegment) {
        if (segmentRepository.existsById(id)) {
            updatedSegment.setId(id);
            return segmentRepository.save(updatedSegment);
        } else {
            throw new RuntimeException("Segment not found");
        }
    }

    // Supprimer un segment
    public void deleteSegment(Long id) {
        if (segmentRepository.existsById(id)) {
            segmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Segment not found");
        }
    }
}
