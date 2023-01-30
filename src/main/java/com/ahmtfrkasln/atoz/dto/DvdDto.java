package com.ahmtfrkasln.atoz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DvdDto extends ProductJson{
    private Long id;
    private Long runTime;
}
