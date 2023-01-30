package com.ahmtfrkasln.atoz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CdDto extends ProductJson{
    private Long id;
    private String artist;
    private Long tracksCount;
}
