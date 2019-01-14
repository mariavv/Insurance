package mariav.insurance.model.entity;

import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import mariav.insurance.model.Consts;

import static mariav.insurance.model.Consts.WORDS_SEPARATE;

public class Policy {

    private static final String RUBLI = "\u20BD";

    private int id;
    @SerializedName("category_code")
    private String categoryCode;
    private String description;
    private String balance;
    @SerializedName("end_date")
    private String endDate;

    public Policy(int id, String categoryCode, String description, String balance, String endDate) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.description = description;
        this.balance = balance;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getDescription() {
        return description;
    }

    public String getBalance() {
        return balance;
    }

    public String getFormattedBalance() {
        return getFormattedBalance('.');
    }

    public String getFormattedBalanceWithDecimalPoint() {
        return getFormattedBalance(',');
    }

    public String getEndDate() {
        return endDate;
    }

    public String getFormattedDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date d = null;
        try {
            d = format.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format2 = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return format2.format(d);
    }

    private String getFormattedBalance(Character decimalSeparator) {
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        formatSymbols.setDecimalSeparator(decimalSeparator);
        formatSymbols.setGroupingSeparator(' ');

        String format = ",##0.00";
        DecimalFormat formatter = new DecimalFormat(format, formatSymbols);

        float value = Float.valueOf(balance);
        return formatter.format(value) + WORDS_SEPARATE + RUBLI;
    }

    public String getFullDescription() {
        String fullDescription = Consts.WORDS_SEPARATE + description;
        switch (categoryCode) {
            case Consts.HEALTH_CATEGORY_CODE:
                fullDescription = Consts.DMS + fullDescription;
                break;
            case Consts.CAR_CATEGORY_CODE:
                fullDescription = Consts.CASCO + fullDescription;
                break;
        }
        return fullDescription;
    }
}
