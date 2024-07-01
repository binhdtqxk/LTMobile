package com.example.GoogleCalendar;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.agogs.holidayapi.api.APIConsumer;
import com.github.agogs.holidayapi.api.impl.HolidayAPIConsumer;
import com.github.agogs.holidayapi.model.Holiday;
import com.github.agogs.holidayapi.model.HolidayAPIResponse;
import com.github.agogs.holidayapi.model.QueryParams;

import java.io.IOException;
import java.util.List;

public class HolidayFragment extends Fragment {

    private APIConsumer apiConsumer;
    private TextView resultTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize APIConsumer with your base URL
        apiConsumer = new HolidayAPIConsumer(getString(R.string.ca140450_57f2_4985_b50d_6cd1b6056722));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_holiday, container, false);

        // Initialize views
        resultTextView = view.findViewById(R.id.resultTextView);
        Button fetchButton = view.findViewById(R.id.fetchButton);
        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchHolidays();
            }
        });

        return view;
    }

    private void fetchHolidays() {
        // Example usage of APIConsumer to fetch holidays
        QueryParams params = new QueryParams()
                .key("ca140450_57f2_4985_b50d_6cd1b6056722")
                .month(1)
                .country(QueryParams.Country.UNITED_STATES)
                .year(2024)
                .format(QueryParams.Format.JSON)
                .pretty(true);

        try {
            HolidayAPIResponse response = apiConsumer.getHolidays(params);

            // Handle response
            int status = response.getStatus();
            if (status == 200) {
                List<Holiday> holidays = response.getHolidays();
                StringBuilder sb = new StringBuilder();
                for (Holiday h : holidays) {
                    sb.append(h.getName()).append(" - ").append(h.getDate()).append("\n");
                }
                resultTextView.setText(sb.toString());
            } else {
                resultTextView.setText("API call failed with status code: " + status);
            }
        } catch (IOException e) {
            e.printStackTrace();
            resultTextView.setText("Error occurred: " + e.getMessage());
        }
    }
}
