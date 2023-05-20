package sopt.sopkathon.soptkathon9th.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.sopkathon.soptkathon9th.controller.dto.request.SituationProceedRequestDto;
import sopt.sopkathon.soptkathon9th.controller.dto.request.SituationResultRequestDto;
import sopt.sopkathon.soptkathon9th.controller.dto.response.SituationResultResponseDto;
import sopt.sopkathon.soptkathon9th.domain.*;
import sopt.sopkathon.soptkathon9th.exception.model.NotFoundException;
import sopt.sopkathon.soptkathon9th.repository.ClientRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationProceedRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationResultRepository;

import javax.transaction.Transactional;

import static sopt.sopkathon.soptkathon9th.exception.Error.*;

@Service
@RequiredArgsConstructor
public class SituationService {
    private final SituationRepository situationRepository;
    private final SituationResultRepository situationResultRepository;
    private final SituationProceedRepository situationProceedRepository;
    private final ClientRepository clientRepository;

    public SituationResultResponseDto getSituationResult(final SituationResultRequestDto request) {
        Situation situation = getSituation(request);
        SituationResult situationResult = getSituationResult(situation);

        return SituationResultResponseDto.from(situationResult.getResult());
    }

    private SituationResult getSituationResult(Situation situation) {
        return situationResultRepository.findBySituation(situation)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_SITUATION_EXCEPTION, NOT_EXIST_SITUATION_EXCEPTION.getMessage()));
    }

    @Transactional
    public void proceedSituation(SituationProceedRequestDto request) {
        Situation situation = getSituation(request);
        Client client = getClient(request);

        situationProceedRepository.changeSituationProceedState(client, situation);
    }

    private Client getClient(SituationProceedRequestDto request) {
        return clientRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_CLIENT_EXCEPTION, NOT_EXIST_CLIENT_EXCEPTION.getMessage()));
    }

    private Situation getSituation(SituationResultRequestDto request) {
        SituationWhat situationWhat;
        SituationWhere situationWhere;
        SituationIn situationIn;


        try {
            situationWhat = SituationWhat.valueOf(request.getSituationWhat());
            situationWhere = SituationWhere.valueOf(request.getSituationWhere());
            situationIn = SituationIn.valueOf(request.getSituationIn());

        } catch (Exception e) {

            throw new NotFoundException(NOT_EXIST_SITUATION_DATA_EXCEPTION, NOT_EXIST_SITUATION_DATA_EXCEPTION.getMessage());
        }

        return situationRepository.findSituationBySituationData(
                        situationWhat,
                        situationWhere,
                        situationIn
                )
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_SITUATION_DATA_EXCEPTION, NOT_EXIST_SITUATION_DATA_EXCEPTION.getMessage()));
    }

    private Situation getSituation(SituationProceedRequestDto request) {
        SituationWhat situationWhat;
        SituationWhere situationWhere;
        SituationIn situationIn;

        try {
            situationWhat = SituationWhat.valueOf(request.getSituationWhat());
            situationWhere = SituationWhere.valueOf(request.getSituationWhere());
            situationIn = SituationIn.valueOf(request.getSituationIn());

        } catch (Exception e) {
            throw new NotFoundException(NOT_EXIST_SITUATION_DATA_EXCEPTION, NOT_EXIST_SITUATION_DATA_EXCEPTION.getMessage());
        }

        return situationRepository.findSituationBySituationData(
                        situationWhat,
                        situationWhere,
                        situationIn
                )
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_SITUATION_DATA_EXCEPTION, NOT_EXIST_SITUATION_DATA_EXCEPTION.getMessage()));
    }
}
