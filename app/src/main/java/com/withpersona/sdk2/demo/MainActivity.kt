package com.withpersona.sdk2.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.withpersona.sdk2.inquiry.*
import android.util.Log

class MainActivity : AppCompatActivity() {
    companion object {
        private const val TEMPLATE_ID: String = "itmpl_YVq84o2UvqeM1t3B4mFdPbzd"
    }

    private val getInquiry = registerForActivityResult(Inquiry.Contract()) {
            inquiry ->
        when (inquiry) {
            is InquiryResponse.Complete -> {
                // FIXME: birthdate is parsed as UnknownField. How can we fetch its value?
                // Refer to attached json for inquiry_id: inq_bfRFU48dTbEG7XdLMSBo6dcv
                Log.d("","${(inquiry.fields["birthdate"] as InquiryField.UnknownField).type}")
                Log.d("","${(inquiry.fields["nameLast"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["nameFirst"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["nameMiddle"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["addressCity"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["phoneNumber"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["emailAddress"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["currentSelfie"] as InquiryField.UnknownField).type}")
                Log.d("","${(inquiry.fields["addressStreet1"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["addressStreet2"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["selectedIdClass"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["addressPostalCode"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["addressSubdivision"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["addressCountryCode"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["identificationClass"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["currentGovernmentId"] as InquiryField.UnknownField).type}")
                Log.d("","${(inquiry.fields["identificationNumber"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["selectedCountryCode"] as InquiryField.StringField).value}")
                Log.d("","${(inquiry.fields["socialSecurityNumber"] as InquiryField.StringField).value}")
            }
            is InquiryResponse.Cancel -> {

            }
            is InquiryResponse.Error -> {

            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getInquiry.launch(
            Inquiry.fromTemplate(TEMPLATE_ID)
                .environment(Environment.SANDBOX)
                .build()
        )

    }
 }
