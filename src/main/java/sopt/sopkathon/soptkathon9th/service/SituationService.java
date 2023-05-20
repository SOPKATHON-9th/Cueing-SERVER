package sopt.sopkathon.soptkathon9th.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.sopkathon.soptkathon9th.controller.dto.request.SituationResultRequestDto;
import sopt.sopkathon.soptkathon9th.domain.*;
import sopt.sopkathon.soptkathon9th.exception.Error;
import sopt.sopkathon.soptkathon9th.exception.model.NotFoundException;
import sopt.sopkathon.soptkathon9th.repository.SituationRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationResultRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SituationService {
    private final SituationRepository situationRepository;
    private final SituationResultRepository situationResultRepository;

    public String getSituationResult(final SituationResultRequestDto request) {
        Situation situation = getSituation(request);
        SituationResult situationResult = getSituationResult(situation);

        return situationResult.getResult();
    }

    private SituationResult getSituationResult(Situation situation) {
        return situationResultRepository.findBySituation(situation)
                .orElseThrow(() -> new NotFoundException(Error.NOT_EXIST_SITUATION_EXCEPTION, Error.NOT_EXIST_SITUATION_EXCEPTION.getMessage()));
    }

    private Situation getSituation(SituationResultRequestDto request) {
        SituationWhat situationWhat = SituationWhat.valueOf(request.getSituationWhat());
        SituationWhere situationWhere = SituationWhere.valueOf(request.getSituationWhere());
        SituationIn situationIn = SituationIn.valueOf(request.getSituationIn());

        return situationRepository.findSituationBySituationData(
                        situationWhat,
                        situationWhere,
                        situationIn
                )
                .orElseThrow(() -> new NotFoundException(Error.NOT_EXIST_SITUATION_DATA_EXCEPTION, Error.NOT_EXIST_SITUATION_DATA_EXCEPTION.getMessage()));
    }
}
