package com.johnathanmsmith.mvc.web.config;

public class ErrorDTO
{
    private String ex;
    private String errorMsgMark;
    private String errorMsgColor;
    private String errorMsgVin;
    private String errorMsgMiles;

    public ErrorDTO (String ex)
    {
        this.ex = ex;
    }

    public String getEx()
    {
        return ex;
    }

    public void setEx(String ex)
    {
        this.ex = ex;
    }

    public String getErrorMsgMark()
    {
        return errorMsgMark;
    }

    public void setErrorMsgMark(String errorMsgMark)
    {
        this.errorMsgMark = errorMsgMark;
    }

    public String getErrorMsgColor()
    {
        return errorMsgColor;
    }

    public void setErrorMsgColor(String errorMsgColor)
    {
        this.errorMsgColor = errorMsgColor;
    }

    public String getErrorMsgVin()
    {
        return errorMsgVin;
    }

    public void setErrorMsgVin(String errorMsgVin)
    {
        this.errorMsgVin = errorMsgVin;
    }

    public String getErrorMsgMiles()
    {
        return errorMsgMiles;
    }

    public void setErrorMsgMiles(String errorMsgMiles)
    {
        this.errorMsgMiles = errorMsgMiles;
    }

    public void ExceptionHandler ()
    {
        for(int i = 0; i < getEx().length(); i++)
        {
            if(getEx().contains("Название автомобиля, должно иметь минимум 2 символа, и максимум 30 символов."))
            {
                errorMsgMark = "Отказано сервером: \"Название автомобиля, должно иметь минимум 2 символа, и максимум 30 символов.\"";
            }
            else errorMsgMark = "Принято сервером!";

            errorMsgColor = "Принято сервером!";

            if(getEx().contains("Vin номер автомобиля, должно начинаться минимум с 1."))
            {
                errorMsgVin = "Отказано сервером: \"Vin номер автомобиля, должно начинаться минимум с 1.\"";
            }
            else errorMsgVin = "Принято сервером!";

            if(getEx().contains("Указанный диапозон миль может находиться в пределах от 1 до 9999."))
            {
                errorMsgMiles = "Отказано сервером: \"Указанный диапозон миль может находиться в пределах от 1 до 9999.\"";
            }
            else errorMsgMiles = "Принято сервером!";
        }
    }

}
