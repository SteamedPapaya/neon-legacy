package com.mouken.modules.party.event;

import com.mouken.infra.config.AppProperties;
import com.mouken.infra.mail.EmailService;
import com.mouken.modules.account.Account;
import com.mouken.modules.account.AccountRepository;
import com.mouken.modules.party.Party;
import com.mouken.modules.party.PartyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;

@Slf4j
@Async
@Component
@Transactional
@RequiredArgsConstructor
public class PartyEventListener {

    private final PartyRepository partyRepository;
//    private final AccountRepository accountRepository;
//    private final EmailService emailService;
//    private final TemplateEngine templateEngine;
//    private final AppProperties appProperties;
//    private final NotificationRepository notificationRepository;

/*    @EventListener
    public void handlePartyCreatedEvent(PartyCreatedEvent partyCreatedEvent) {
        Party party = partyRepository.findPartyWithTagsAndZonesById(partyCreatedEvent.getParty().getId());
        Iterable<Account> accounts = accountRepository.findAll(AccountPredicates.findByTagsAndZones(party.getTags(), party.getZones()));
        accounts.forEach(account -> {
            if (account.isPartyCreatedByEmail()) {
                sendPartyCreatedEmail(party, account);
            }

            if (account.isPartyCreatedByWeb()) {
                savePartyCreatedNotification(party, account);
            }
        });
    }*/

/*    private void savePartyCreatedNotification(Party party, Account account) {
        Notification notification = new Notification();
        notification.setTitle(party.getTitle());
        notification.setLink("/party/" + party.getEncodedPath());
        notification.setChecked(false);
        notification.setCreatedLocalDateTime(LocalDateTime.now());
        notification.setMessage(party.getShortDescription());
        notification.setAccount(account);
        notification.setNotificationType(NotificationType.STUDY_CREATED);
        notificationRepository.save(notification);
    }

    private void sendPartyCreatedEmail(Party party, Account account) {
        Context context = new Context();
        context.setVariable("nickname", account.getNickname());
        context.setVariable("link", "/party/" + party.getEncodedPath());
        context.setVariable("linkName", party.getTitle());
        context.setVariable("message", "새로운 스터디가 생겼습니다");
        context.setVariable("host", appProperties.getHost());
        String message = templateEngine.process("mail/simple-link", context);

        EmailMessage emailMessage = EmailMessage.builder()
                .subject("스터디올래, '" + party.getTitle() + "' 스터디가 생겼습니다.")
                .to(account.getEmail())
                .message(message)
                .build();

        emailService.sendEmail(emailMessage);
    }*/

}
