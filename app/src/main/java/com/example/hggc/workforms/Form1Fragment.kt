package com.example.hggc.workforms

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TimePicker
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.example.hggc.R
import jxl.Workbook
import jxl.write.Label
import jxl.write.WritableSheet
import jxl.write.WritableWorkbook
import jxl.write.WriteException
import jxl.write.biff.RowsExceededException
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class Form1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Accessing the form elements by their IDs


        val terminalArrivalSpinner = view.findViewById<Spinner>(R.id.terminalArrivalSpinner)
        val terminalArrivalOptions =
            arrayOf("Lahore", "Islamabad", "Hyderabad") // Replace with your data
        val terminalArrivalAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            terminalArrivalOptions
        )
        terminalArrivalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        terminalArrivalSpinner.adapter = terminalArrivalAdapter


        val terminalDepartureSpinner = view.findViewById<Spinner>(R.id.terminalDepartureSpinner)
        val terminalDepartureOptions =
            arrayOf("Kemari KT", "Matiari", "Other") // Replace with your data
        val terminalDepartureAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            terminalDepartureOptions
        )
        terminalDepartureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        terminalDepartureSpinner.adapter = terminalDepartureAdapter


        val vehicleNumberSpinner = view.findViewById<Spinner>(R.id.vehicleNumberSpinner)
        val vehicleNumberOptions =
            arrayOf("Vehicle 1", "Vehicle 2", "Vehicle 3") // Replace with your data
        val vehicleNumberAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            vehicleNumberOptions
        )
        vehicleNumberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        vehicleNumberSpinner.adapter = vehicleNumberAdapter


        // Accessing the selected date from DatePicker
        val calendar = Calendar.getInstance()
        var datePicker = view.findViewById<DatePicker>(R.id.datePicker)
        var timePicker = view.findViewById<TimePicker>(R.id.timePicker)

        // Set the date in DatePicker
        datePicker.init(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
            null
        )

        // Set the time in TimePicker
        timePicker.hour = calendar.get(Calendar.HOUR_OF_DAY)
        timePicker.minute = calendar.get(Calendar.MINUTE)


        val saveButton = view.findViewById<Button>(R.id.buttonSave)
        saveButton.setOnClickListener {

            val d1nameValue = view.findViewById<EditText>(R.id.d1name).text.toString()
            val d2nameValue = view.findViewById<EditText>(R.id.d2name).text.toString()
            val terminalArrivalValue = terminalArrivalSpinner.selectedItem.toString()
            val terminalDepartureValue = terminalDepartureSpinner.selectedItem.toString()
            val odostartValue = view.findViewById<EditText>(R.id.odostart).text.toString()
            val odoendValue = view.findViewById<EditText>(R.id.odoend).text.toString()
            val vehicleNumberValue = vehicleNumberSpinner.selectedItem.toString()

            datePicker =
                view.findViewById(R.id.datePicker) // Replace with your DatePicker
            timePicker =
                view.findViewById(R.id.timePicker)

// Get the selected date
            val year = datePicker.year
            val month = datePicker.month
            val dayOfMonth = datePicker.dayOfMonth

// Get the selected time
            val hour = timePicker.hour
            val minute = timePicker.minute

// Format the date and time
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            val formattedDate = dateFormat.format(Date(year - 1900, month, dayOfMonth))
            val formattedTime = timeFormat.format(Date(0, 0, 0, hour, minute))

// Now, you have `formattedDate` and `formattedTime` to add to your `fieldValues` map.


            // Create a map with field names and values
            val outputFile = File(requireContext().getExternalFilesDir(null), "TripLog.csv")

// Define the field values from the form
            val fieldValues = mapOf(
                "Driver 1" to d1nameValue,
                "Driver 2" to d2nameValue,

                "Terminal Departure" to terminalDepartureValue,
                "Terminal Arrival" to terminalArrivalValue,

                "Odometer Start" to odostartValue,
                "Odometer End" to odoendValue,

                "Vehicle No." to vehicleNumberValue,
                "Date" to formattedDate, // Add the formatted date
                "Time" to formattedTime // Add the formatted time


//                "Destination" to "", // You can populate this with the appropriate value
//                "Contractor" to "", // You can populate this with the appropriate value
//                "Trip No." to "", // You can populate this with the appropriate value
//
//                "Diesel" to "" // You can populate this with the appropriate value
            )

// Call the function to create the CSV file
            createXLSXFileForDataEntry(outputFile, fieldValues)


            val recipientEmail = "buttawb@gmail.com" // Replace with the recipient's email address
            val subject = "Trip Log Form Data"
            val message = "Please find the attached trip log form data."

            sendExcelViaEmail(outputFile)

        }
    }

    private fun createXLSXFileForDataEntry(outputFile: File, fieldValues: Map<String, String>) {
        try {
            val writableWorkbook: WritableWorkbook = Workbook.createWorkbook(outputFile)
            val sheet: WritableSheet = writableWorkbook.createSheet("Data", 0)

            // Add a merged cell for "TRIP LOG" as the heading
            val mergeColumnStart = 0 // Start column
            val mergeColumnEnd = fieldValues.size - 1 // End column
            val mergeRowStart = 0 // Start row
            val mergeRowEnd = 0 // End row
            sheet.mergeCells(mergeColumnStart, mergeRowStart, mergeColumnEnd, mergeRowEnd)

            // Create the header row with merged cell
            val headers = fieldValues.keys.toList()
            val mergedHeaderLabel = Label(mergeColumnStart, mergeRowStart, "TRIP LOG")
            sheet.addCell(mergedHeaderLabel)

            // Create the header row
            for ((index, header) in headers.withIndex()) {
                val label = Label(index, mergeRowEnd + 1, header)
                sheet.addCell(label)
            }

            // Create the data row
            val data = headers.map { fieldValues[it] ?: "" }
            for ((index, value) in data.withIndex()) {
                val label = Label(index, mergeRowEnd + 2, value)
                sheet.addCell(label)
            }

            writableWorkbook.write()
            writableWorkbook.close()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: RowsExceededException) {
            e.printStackTrace()
        } catch (e: WriteException) {
            e.printStackTrace()
        }
    }


// Now, you can send the Excel file using the sendPdfViaEmail function you provided earlier

    private fun sendExcelViaEmail(excelFile: File) {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type =
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" // MIME type for Excel files (.xlsx)
            putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf("buttawb@gmail.com")
            ) // Replace with recipient's email
            putExtra(Intent.EXTRA_SUBJECT, "Form Data (Excel)") // Update the subject
            putExtra(
                Intent.EXTRA_TEXT,
                "Please find the attached form data in Excel format."
            ) // Update the text
            // Attach the Excel file using FileProvider
            val excelUri = FileProvider.getUriForFile(
                requireContext(),
                "${requireContext().packageName}.provider",
                excelFile
            )
            putExtra(Intent.EXTRA_STREAM, excelUri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION) // Grant read permission to the receiving app
        }

        if (emailIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(emailIntent)
        } else {
            // Handle the case where no email client is available
            // You can display a message or take alternative action
        }
    }

}
