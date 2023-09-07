package com.example.hggc.workforms

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.Switch
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import com.example.hggc.R
import com.itextpdf.text.Document
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream

class Form1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form1, container, false)

        // Find the "Save" button and set a click listener
        val saveButton = view.findViewById<Button>(R.id.buttonSave)
        saveButton.setOnClickListener {
            // Collect data from form fields
            val name = view.findViewById<EditText>(R.id.editTextName).text.toString()
            val gender =
                getSelectedRadioButtonText(view.findViewById<RadioGroup>(R.id.radioGroupGender))
            val music = view.findViewById<CheckBox>(R.id.checkBoxMusic).isChecked.toString()
            val movies = view.findViewById<CheckBox>(R.id.checkBoxMovies).isChecked.toString()
            val sports = view.findViewById<CheckBox>(R.id.checkBoxSports).isChecked.toString()
            val comments = view.findViewById<EditText>(R.id.editTextComments).text.toString()
            val birthdate =
                getFormattedDate(view.findViewById<DatePicker>(R.id.datePickerBirthdate))
            val address = view.findViewById<EditText>(R.id.editTextAddress).text.toString()
            val notificationsEnabled =
                view.findViewById<Switch>(R.id.switchNotifications).isChecked.toString()
            val rating = view.findViewById<SeekBar>(R.id.seekBarRating).progress.toString()
            val password = view.findViewById<EditText>(R.id.editTextPassword).text.toString()
            val email = view.findViewById<EditText>(R.id.editTextEmail).text.toString()
            val age = view.findViewById<EditText>(R.id.editTextAge).text.toString()

            // Create a PDF document
            val pdfFileName = "form_data.pdf"
            val pdfFile = createPdfDocument(
                name, gender, music, movies, sports, comments, birthdate, address,
                notificationsEnabled, rating, password, email, age,
                pdfFileName
            )

            // Send the PDF file via email
            sendPdfViaEmail(pdfFile)
        }

        return view
    }

    private fun getSelectedRadioButtonText(radioGroup: RadioGroup): String {
        val selectedRadioButtonId = radioGroup.checkedRadioButtonId
        val selectedRadioButton = view?.findViewById<RadioButton>(selectedRadioButtonId)
        return selectedRadioButton?.text.toString()
    }

    private fun getFormattedDate(datePicker: DatePicker): String {
        val year = datePicker.year
        val month = datePicker.month + 1 // Month is 0-based, so add 1
        val dayOfMonth = datePicker.dayOfMonth
        return "$year-$month-$dayOfMonth"
    }

    private fun createPdfDocument(
        name: String, gender: String, music: String, movies: String, sports: String,
        comments: String, birthdate: String, address: String, notifications: String,
        rating: String, password: String, email: String, age: String,
        fileName: String
    ): File {
        val pdfFile = File(
            requireContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),
            fileName
        )

        try {
            val document = Document()
            val outputStream = FileOutputStream(pdfFile)
            PdfWriter.getInstance(document, outputStream)
            document.open()

            // Add form data to the PDF
            val data = """
                Name: $name
                Gender: $gender
                Music: $music
                Movies: $movies
                Sports: $sports
                Comments: $comments
                Birthdate: $birthdate
                Address: $address
                Notifications Enabled: $notifications
                Rating: $rating
                Password: $password
                Email: $email
                Age: $age
            """.trimIndent()

            val paragraph = Paragraph(data)
            document.add(paragraph)

            document.close()
            outputStream.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return pdfFile
    }

    private fun sendPdfViaEmail(pdfFile: File) {
        val emailIntent = Intent(Intent.ACTION_SEND).apply {
            type = "application/pdf"
            putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf("buttawb@gmail.com")
            ) // Replace with recipient's email
            putExtra(Intent.EXTRA_SUBJECT, "Form Data")
            putExtra(Intent.EXTRA_TEXT, "Please find the attached form data in PDF format.")
            // Attach the PDF file using FileProvider
            val pdfUri = FileProvider.getUriForFile(
                requireContext(),
                "${requireContext().packageName}.provider",
                pdfFile
            )
            putExtra(Intent.EXTRA_STREAM, pdfUri)
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
