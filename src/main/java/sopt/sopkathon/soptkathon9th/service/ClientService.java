package sopt.sopkathon.soptkathon9th.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;
import sopt.sopkathon.soptkathon9th.controller.dto.request.SituationProceedRequestDto;
import sopt.sopkathon.soptkathon9th.controller.dto.response.ClientMyPageResponseDto;
import sopt.sopkathon.soptkathon9th.controller.dto.response.SituationProceedDto;
import sopt.sopkathon.soptkathon9th.domain.Client;
import sopt.sopkathon.soptkathon9th.domain.SituationProceed;
import sopt.sopkathon.soptkathon9th.exception.model.NotFoundException;
import sopt.sopkathon.soptkathon9th.repository.ClientRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationProceedRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationRepository;

import java.util.List;
import java.util.stream.Collectors;

import static sopt.sopkathon.soptkathon9th.exception.Error.NOT_EXIST_CLIENT_EXCEPTION;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientService {

    private final SituationProceedRepository situationProceedRepository;
    private final ClientRepository clientRepository;

    public ClientMyPageResponseDto getMyPage(Long userId) {
        Client client = getClient(userId);
        List<SituationProceed> clientSituationProceedDatum = situationProceedRepository.findByClient(client);
        int proceedCount = getProceedCount(clientSituationProceedDatum);

        List<SituationProceedDto> situationProceedDtos = getSituationProceedDtos(clientSituationProceedDatum, client);
        
        
        return ClientMyPageResponseDto.from(proceedCount, situationProceedDtos);

    }

    private int getProceedCount(List<SituationProceed> clientSituationProceedDatum) {
        return clientSituationProceedDatum.stream()
                .filter(data -> data.isProceed())
                .collect(Collectors.toList())
                .size();
    }

    private List<SituationProceedDto> getSituationProceedDtos(List<SituationProceed> clientSituationProceedDatum, Client client) {
        return clientSituationProceedDatum.stream()
                .map(SituationProceed::toDto)
                .collect(Collectors.toList());
    }

    private Client getClient(Long userId) {
        return clientRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(NOT_EXIST_CLIENT_EXCEPTION, NOT_EXIST_CLIENT_EXCEPTION.getMessage()));
    }
}
