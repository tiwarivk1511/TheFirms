package com.android.thefirms.ratings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.thefirms.R;
import com.android.thefirms.databinding.ActivityRatingBinding;

import java.util.ArrayList;

public class RatingActivity extends AppCompatActivity {

    ActivityRatingBinding binding;

    // Array containing the available industry options
    String[] industryOptions = {
            "Education", "Social", "Financial", "Startups", "Enterprise",
            "E-commerce", "Business Intelligence", "Real Estate", "Healthcare",
            "Travel", "Game", "Entertainment", "Consumer", "News",
            "Gambling", "Non Profit", "Productivity"
    };


    String[] projectStatus= {"Initial","On Process", "Complete", "Delivered"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRatingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Window window = this.getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black));


        ArrayList<CurrencyItem> currencyList = new ArrayList<>();

        // Add the currency objects to the list
        currencyList.add(new CurrencyItem("AED", "United Arab Emirates Dirham"));
        currencyList.add(new CurrencyItem("AFN", "Afghan Afghani"));
        currencyList.add(new CurrencyItem("ALL", "Albanian Lek"));
        currencyList.add(new CurrencyItem("AMD", "Armenian Dram"));
        currencyList.add(new CurrencyItem("ANG", "Netherlands Antillean Guilder"));
        currencyList.add(new CurrencyItem("AOA", "Angolan Kwanza"));
        currencyList.add(new CurrencyItem("ARS", "Argentine Peso"));
        currencyList.add(new CurrencyItem("AUD", "Australian Dollar"));
        currencyList.add(new CurrencyItem("AWG", "Aruban Florin"));
        currencyList.add(new CurrencyItem("AZN", "Azerbaijani Manat"));
        currencyList.add(new CurrencyItem("BAM", "Bosnia and Herzegovina Convertible Mark"));
        currencyList.add(new CurrencyItem("BBD", "Barbadian or Bajan Dollar"));
        currencyList.add(new CurrencyItem("BDT", "Bangladeshi Taka"));
        currencyList.add(new CurrencyItem("BGN", "Bulgarian Lev"));
        currencyList.add(new CurrencyItem("BHD", "Bahraini Dinar"));
        currencyList.add(new CurrencyItem("BIF", "Burundian Franc"));
        currencyList.add(new CurrencyItem("BMD", "Bermudian Dollar"));
        currencyList.add(new CurrencyItem("BND", "Bruneian Dollar"));
        currencyList.add(new CurrencyItem("BOB", "Bolivian Bolíviano"));
        currencyList.add(new CurrencyItem("BRL", "Brazilian Real"));
        currencyList.add(new CurrencyItem("BSD", "Bahamian Dollar"));
        currencyList.add(new CurrencyItem("BTN", "Bhutanese Ngultrum"));
        currencyList.add(new CurrencyItem("BWP", "Botswana Pula"));
        currencyList.add(new CurrencyItem("BYN", "Belarusian Ruble"));
        currencyList.add(new CurrencyItem("BZD", "Belizean Dollar"));
        currencyList.add(new CurrencyItem("CAD", "Canadian Dollar"));
        currencyList.add(new CurrencyItem("CDF", "Congolese Franc"));
        currencyList.add(new CurrencyItem("CHF", "Swiss Franc"));
        currencyList.add(new CurrencyItem("CLP", "Chilean Peso"));
        currencyList.add(new CurrencyItem("CNY", "Chinese Yuan Renminbi"));
        currencyList.add(new CurrencyItem("COP", "Colombian Peso"));
        currencyList.add(new CurrencyItem("CRC", "Costa Rican Colon"));
        currencyList.add(new CurrencyItem("CUC", "Cuban Convertible Peso"));
        currencyList.add(new CurrencyItem("CUP", "Cuban Peso"));
        currencyList.add(new CurrencyItem("CVE", "Cape Verdean Escudo"));
        currencyList.add(new CurrencyItem("CZK", "Czech Koruna"));
        currencyList.add(new CurrencyItem("DJF", "Djiboutian Franc"));
        currencyList.add(new CurrencyItem("DKK", "Danish Krone"));
        currencyList.add(new CurrencyItem("DOP", "Dominican Peso"));
        currencyList.add(new CurrencyItem("DZD", "Algerian Dinar"));
        currencyList.add(new CurrencyItem("EGP", "Egyptian Pound"));
        currencyList.add(new CurrencyItem("ERN", "Eritrean Nakfa"));
        currencyList.add(new CurrencyItem("ETB", "Ethiopian Birr"));
        currencyList.add(new CurrencyItem("EUR", "Euro"));
        currencyList.add(new CurrencyItem("FJD", "Fijian Dollar"));
        currencyList.add(new CurrencyItem("FKP", "Falkland Island Pound"));
        currencyList.add(new CurrencyItem("GBP", "British Pound Sterling"));
        currencyList.add(new CurrencyItem("GEL", "Georgian Lari"));
        currencyList.add(new CurrencyItem("GGP", "Guernsey Pound"));
        currencyList.add(new CurrencyItem("GHS", "Ghanaian Cedi"));
        currencyList.add(new CurrencyItem("GIP", "Gibraltar Pound"));
        currencyList.add(new CurrencyItem("GMD", "Gambian Dalasi"));
        currencyList.add(new CurrencyItem("GNF", "Guinean Franc"));
        currencyList.add(new CurrencyItem("GTQ", "Guatemalan Quetzal"));
        currencyList.add(new CurrencyItem("GYD", "Guyanese Dollar"));
        currencyList.add(new CurrencyItem("HKD", "Hong Kong Dollar"));
        currencyList.add(new CurrencyItem("HNL", "Honduran Lempira"));
        currencyList.add(new CurrencyItem("HRK", "Croatian Kuna"));
        currencyList.add(new CurrencyItem("HTG", "Haitian Gourde"));
        currencyList.add(new CurrencyItem("HUF", "Hungarian Forint"));
        currencyList.add(new CurrencyItem("IDR", "Indonesian Rupiah"));
        currencyList.add(new CurrencyItem("ILS", "Israeli Shekel"));
        currencyList.add(new CurrencyItem("IMP", "Isle of Man Pound"));
        currencyList.add(new CurrencyItem("INR", "Indian Rupee"));
        currencyList.add(new CurrencyItem("IQD", "Iraqi Dinar"));
        currencyList.add(new CurrencyItem("IRR", "Iranian Rial"));
        currencyList.add(new CurrencyItem("ISK", "Icelandic Krona"));
        currencyList.add(new CurrencyItem("JEP", "Jersey Pound"));
        currencyList.add(new CurrencyItem("JMD", "Jamaican Dollar"));
        currencyList.add(new CurrencyItem("JOD", "Jordanian Dinar"));
        currencyList.add(new CurrencyItem("JPY", "Japanese Yen"));
        currencyList.add(new CurrencyItem("KES", "Kenyan Shilling"));
        currencyList.add(new CurrencyItem("KGS", "Kyrgyzstani Som"));
        currencyList.add(new CurrencyItem("KHR", "Cambodian Riel"));
        currencyList.add(new CurrencyItem("KMF", "Comorian Franc"));
        currencyList.add(new CurrencyItem("KPW", "North Korean Won"));
        currencyList.add(new CurrencyItem("KRW", "South Korean Won"));
        currencyList.add(new CurrencyItem("KWD", "Kuwaiti Dinar"));
        currencyList.add(new CurrencyItem("KYD", "Caymanian Dollar"));
        currencyList.add(new CurrencyItem("KZT", "Kazakhstani Tenge"));
        currencyList.add(new CurrencyItem("LAK", "Lao Kip"));
        currencyList.add(new CurrencyItem("LBP", "Lebanese Pound"));
        currencyList.add(new CurrencyItem("LKR", "Sri Lankan Rupee"));
        currencyList.add(new CurrencyItem("LRD", "Liberian Dollar"));
        currencyList.add(new CurrencyItem("LSL", "Basotho Loti"));
        currencyList.add(new CurrencyItem("LYD", "Libyan Dinar"));
        currencyList.add(new CurrencyItem("MAD", "Moroccan Dirham"));
        currencyList.add(new CurrencyItem("MDL", "Moldovan Leu"));
        currencyList.add(new CurrencyItem("MGA", "Malagasy Ariary"));
        currencyList.add(new CurrencyItem("MKD", "Macedonian Denar"));
        currencyList.add(new CurrencyItem("MMK", "Burmese Kyat"));
        currencyList.add(new CurrencyItem("MNT", "Mongolian Tughrik"));
        currencyList.add(new CurrencyItem("MOP", "Macau Pataca"));
        currencyList.add(new CurrencyItem("MRO", "Mauritanian Ouguiya"));
        currencyList.add(new CurrencyItem("MUR", "Mauritian Rupee"));
        currencyList.add(new CurrencyItem("MVR", "Maldivian Rufiyaa"));
        currencyList.add(new CurrencyItem("MWK", "Malawian Kwacha"));
        currencyList.add(new CurrencyItem("MXN", "Mexican Peso"));
        currencyList.add(new CurrencyItem("MYR", "Malaysian Ringgit"));
        currencyList.add(new CurrencyItem("MZN", "Mozambican Metical"));
        currencyList.add(new CurrencyItem("NAD", "Namibian Dollar"));
        currencyList.add(new CurrencyItem("NGN", "Nigerian Naira"));
        currencyList.add(new CurrencyItem("NIO", "Nicaraguan Cordoba"));
        currencyList.add(new CurrencyItem("NOK", "Norwegian Krone"));
        currencyList.add(new CurrencyItem("NPR", "Nepalese Rupee"));
        currencyList.add(new CurrencyItem("NZD", "New Zealand Dollar"));
        currencyList.add(new CurrencyItem("OMR", "Omani Rial"));
        currencyList.add(new CurrencyItem("PAB", "Panamanian Balboa"));
        currencyList.add(new CurrencyItem("PEN", "Peruvian Sol"));
        currencyList.add(new CurrencyItem("PGK", "Papua New Guinean Kina"));
        currencyList.add(new CurrencyItem("PHP", "Philippine Peso"));
        currencyList.add(new CurrencyItem("PKR", "Pakistani Rupee"));
        currencyList.add(new CurrencyItem("PLN", "Polish Zloty"));
        currencyList.add(new CurrencyItem("PYG", "Paraguayan Guarani"));
        currencyList.add(new CurrencyItem("QAR", "Qatari Riyal"));
        currencyList.add(new CurrencyItem("RON", "Romanian Leu"));
        currencyList.add(new CurrencyItem("RSD", "Serbian Dinar"));
        currencyList.add(new CurrencyItem("RUB", "Russian Ruble"));
        currencyList.add(new CurrencyItem("RWF", "Rwandan Franc"));
        currencyList.add(new CurrencyItem("SAR", "Saudi Arabian Riyal"));
        currencyList.add(new CurrencyItem("SBD", "Solomon Islander Dollar"));
        currencyList.add(new CurrencyItem("SCR", "Seychellois Rupee"));
        currencyList.add(new CurrencyItem("SDG", "Sudanese Pound"));
        currencyList.add(new CurrencyItem("SEK", "Swedish Krona"));
        currencyList.add(new CurrencyItem("SGD", "Singapore Dollar"));
        currencyList.add(new CurrencyItem("SHP", "Saint Helenian Pound"));
        currencyList.add(new CurrencyItem("SLL", "Sierra Leonean Leone"));
        currencyList.add(new CurrencyItem("SOS", "Somali Shilling"));
        currencyList.add(new CurrencyItem("SPL", "Seborgan Luigino"));
        currencyList.add(new CurrencyItem("SRD", "Surinamese Dollar"));
        currencyList.add(new CurrencyItem("STN", "Sao Tomean Dobra"));
        currencyList.add(new CurrencyItem("SVC", "Salvadoran Colon"));
        currencyList.add(new CurrencyItem("SYP", "Syrian Pound"));
        currencyList.add(new CurrencyItem("SZL", "Swazi Lilangeni"));
        currencyList.add(new CurrencyItem("THB", "Thai Baht"));
        currencyList.add(new CurrencyItem("TJS", "Tajikistani Somoni"));
        currencyList.add(new CurrencyItem("TMT", "Turkmenistani Manat"));
        currencyList.add(new CurrencyItem("TND", "Tunisian Dinar"));
        currencyList.add(new CurrencyItem("TOP", "Tongan Pa'anga"));
        currencyList.add(new CurrencyItem("TRY", "Turkish Lira"));
        currencyList.add(new CurrencyItem("TTD", "Trinidadian Dollar"));
        currencyList.add(new CurrencyItem("TVD", "Tuvaluan Dollar"));
        currencyList.add(new CurrencyItem("TWD", "Taiwanese New Dollar"));
        currencyList.add(new CurrencyItem("TZS", "Tanzanian Shilling"));
        currencyList.add(new CurrencyItem("UAH", "Ukrainian Hryvnia"));
        currencyList.add(new CurrencyItem("UGX", "Ugandan Shilling"));
        currencyList.add(new CurrencyItem("USD", "United States Dollar"));
        currencyList.add(new CurrencyItem("UYU", "Uruguayan Peso"));
        currencyList.add(new CurrencyItem("UZS", "Uzbekistani Som"));
        currencyList.add(new CurrencyItem("VEF", "Venezuelan Bolívar"));
        currencyList.add(new CurrencyItem("VND", "Vietnamese Dong"));
        currencyList.add(new CurrencyItem("VUV", "Ni-Vanuatu Vatu"));
        currencyList.add(new CurrencyItem("WST", "Samoan Tala"));
        currencyList.add(new CurrencyItem("XAF", "Central African CFA Franc BEAC"));
        currencyList.add(new CurrencyItem("XCD", "East Caribbean Dollar"));
        currencyList.add(new CurrencyItem("XDR", "IMF Special Drawing Rights"));
        currencyList.add(new CurrencyItem("XOF", "West African CFA Franc BCEAO"));
        currencyList.add(new CurrencyItem("XPF", "CFP Franc"));
        currencyList.add(new CurrencyItem("YER", "Yemeni Rial"));
        currencyList.add(new CurrencyItem("ZAR", "South African Rand"));
        currencyList.add(new CurrencyItem("ZMW", "Zambian Kwacha"));
        currencyList.add(new CurrencyItem("ZWD", "Zimbabwean Dollar"));

        // Set up ArrayAdapter for IndustryTypeAutoCompleteTxtView
        ArrayAdapter<String> industryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, industryOptions);
        binding.IndustryTypeAutoCompleteTxtView.setAdapter(industryAdapter);

        // Set up item click listener to handle selection
        binding.IndustryTypeAutoCompleteTxtView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedIndustry = (String) parent.getItemAtPosition(position);
                // Set the selected industry to the IndustryTypeAutoCompleteTxtView
                binding.IndustryTypeAutoCompleteTxtView.setText(selectedIndustry);
            }
        });

        binding.currencyPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new PopupWindow
                PopupWindow popupWindow = new PopupWindow(RatingActivity.this);

                // Set the content view of the PopupWindow to your custom layout
                View popupView = getLayoutInflater().inflate(R.layout.currency_popup, null);
                popupWindow.setContentView(popupView);

                // Find views in the popup layout
                ListView listView = popupView.findViewById(R.id.currencyList);
                EditText searchEditText = popupView.findViewById(R.id.SearchCurrency);

                // Create a copy of the original currency list
                ArrayList<CurrencyItem> filteredList = new ArrayList<>(currencyList);

                // Create an ArrayAdapter for the list of currencies
                ArrayAdapter<CurrencyItem> currencyAdapter = new ArrayAdapter<CurrencyItem>(
                        RatingActivity.this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        filteredList
                ) {
                    @SuppressLint("SetTextI18n")
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        // Inflate a custom layout for each item in the list
                        if (convertView == null) {
                            convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);
                        }
                        // Bind data to the custom layout
                        CurrencyItem item = getItem(position);
                        TextView textView = convertView.findViewById(android.R.id.text1);
                        if (item != null) {
                            textView.setText(item.getCode() + " - " + item.getName());

                        }
                        return convertView;
                    }
                };

                // Set the adapter to the ListView
                listView.setAdapter(currencyAdapter);

                // Set a click listener for items in the ListView
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CurrencyItem selectedCurrency = filteredList.get(position);
                        if (selectedCurrency != null) {
                            // Do something with the selected currency
                            // For example, set it to a TextView
                            binding.currencyPicker.setText(selectedCurrency.getCode());
                        }
                        // Dismiss the PopupWindow
                        popupWindow.dismiss();
                    }
                });

                // Add a text change listener to the search EditText
                searchEditText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        // No implementation needed
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        // Filter the currency list based on the search query
                        filteredList.clear();
                        String searchText = s.toString().toLowerCase();
                        for (CurrencyItem item : currencyList) {
                            if (item.getCode().toLowerCase().contains(searchText) || item.getName().toLowerCase().contains(searchText)) {
                                filteredList.add(item);
                            }
                        }
                        // Notify the adapter of the data change
                        currencyAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        // No implementation needed
                    }
                });

                // Set the width and height of the PopupWindow
                popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

                // Set focusable to true to receive touch events outside the PopupWindow
                popupWindow.setFocusable(true);

                // Show the PopupWindow anchored to the currencyPicker view
                popupWindow.showAsDropDown(binding.currencyPicker);
            }
        });


        //Adding Adepter for the ProjectStatus Options
        ArrayAdapter<String> projectAdepter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,projectStatus);
        binding.projectStatusAutoCompleteTxtView.setAdapter(projectAdepter);

        //Set up item click listener to handle status selection
        binding.projectStatusAutoCompleteTxtView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedStatus = (String) parent.getItemAtPosition(position);
                binding.projectStatusAutoCompleteTxtView.setText(selectedStatus);
            }
        });



        //click listener for Next Button
        binding.projectNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });
    }

    private void validateData() {

        if(binding.projectNameTxt.equals("")){
            binding.projectNameTxt.setError("Enter Project Name");
        } else if (binding.descriptionEditTxt.equals("")) {
            binding.descriptionEditTxt.setError("Enter the description of project");
        } else if (binding.costAutoCompleteTxtView.equals("")) {
            binding.costAutoCompleteTxtView.setError("Enter cost of project");
        }else if (binding.IndustryTypeAutoCompleteTxtView.equals("")){
            binding.IndustryTypeAutoCompleteTxtView.setError("Select an Industry");
        } else if (binding.projectStatusAutoCompleteTxtView.equals("")) {
            binding.projectStatusAutoCompleteTxtView.setError("Select the type of project");
        }
        else{
            String projectName = binding.projectNameTxt.getText().toString();
            String description = binding.descriptionEditTxt.getText().toString();
            String cost = binding.costAutoCompleteTxtView.getText().toString();
            String industry = binding.IndustryTypeAutoCompleteTxtView.getText().toString();
            String projectStatus = binding.projectStatusAutoCompleteTxtView.getText().toString();

            Intent intent = new Intent(RatingActivity.this, RatingActivity2.class);
            intent.putExtra("projectName",projectName);
            intent.putExtra("projectDescription",description);
            intent.putExtra("cost",cost);
            intent.putExtra("industry",industry);
            intent.putExtra("projectStatus",projectStatus);
            startActivity(intent);
        }
    }

    class CurrencyItem {
        private String code;
        private String name;

        public CurrencyItem(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}