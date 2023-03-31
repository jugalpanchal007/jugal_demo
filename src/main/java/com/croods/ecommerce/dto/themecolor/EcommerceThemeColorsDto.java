package com.croods.ecommerce.dto.themecolor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EcommerceThemeColorsDto {

	private long userfrontId;
	private String primaryColor;
	private String secondaryColor;
	private String headingColor;
	private String footerColor;
	private String footerTextColor;

}
