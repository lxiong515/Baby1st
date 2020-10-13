package controller;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date>{
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return(attribute == null? null:Date.valueOf(attribute));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		// TODO Auto-generated method stub
		return (dbData == null ? null: dbData.toLocalDate());
	}

}
