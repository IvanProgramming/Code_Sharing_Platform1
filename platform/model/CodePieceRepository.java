package platform.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodePieceRepository extends CrudRepository<CodePiece, Long> {
    List<CodePiece> findFirst10ByTimeRestrictionIsFalseAndViewsRestrictionIsFalseOrderByIdDesc();
    CodePiece getCodePieceByUUIDEquals(String UUID);
}
