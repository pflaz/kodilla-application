package com.crud.tasks.dto.trellocardfields;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AttachmentsByType {
    @JsonProperty("trello")
    private Trello trello;
}
