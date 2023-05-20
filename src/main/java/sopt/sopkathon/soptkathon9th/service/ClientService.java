package sopt.sopkathon.soptkathon9th.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sopt.sopkathon.soptkathon9th.controller.dto.response.ClientMyPageResponseDto;
import sopt.sopkathon.soptkathon9th.controller.dto.response.SituationProceedDto;
import sopt.sopkathon.soptkathon9th.domain.Client;
import sopt.sopkathon.soptkathon9th.domain.Situation;
import sopt.sopkathon.soptkathon9th.domain.SituationProceed;
import sopt.sopkathon.soptkathon9th.exception.model.NotFoundException;
import sopt.sopkathon.soptkathon9th.repository.ClientRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationProceedRepository;
import sopt.sopkathon.soptkathon9th.repository.SituationRepository;

import java.util.List;
import java.util.stream.Collectors;

import static sopt.sopkathon.soptkathon9th.exception.Error.NOT_EXIST_CLIENT_EXCEPTION;

@Service
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientService {

    private final SituationProceedRepository situationProceedRepository;
    private final SituationRepository situationRepository;
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

    public void addUser() {
        try {
            Client savedClient = clientRepository.save(new Client());
            List<Situation> allSituation = situationRepository.findAll();

            for (Situation situation : allSituation) {
                SituationProceed situationProceed = SituationProceed.builder()
                        .client(savedClient)
                        .situation(situation)
                        .isProceed(false)
                        .build();

                situationProceedRepository.save(situationProceed);
            }

        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
