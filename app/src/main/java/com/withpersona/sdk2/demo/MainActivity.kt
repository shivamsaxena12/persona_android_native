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
                Log.d("","birthdate: ${(inquiry.fields["birthdate"] as InquiryField.UnknownField).type}")
                Log.d("","nameLast: ${(inquiry.fields["nameLast"] as InquiryField.StringField).value}")
                Log.d("","nameFirst: ${(inquiry.fields["nameFirst"] as InquiryField.StringField).value}")
                Log.d("","nameMiddle: ${(inquiry.fields["nameMiddle"] as InquiryField.StringField).value}")
                Log.d("","addressCity: ${(inquiry.fields["addressCity"] as InquiryField.StringField).value}")
                Log.d("","phoneNumber: ${(inquiry.fields["phoneNumber"] as InquiryField.StringField).value}")
                Log.d("","emailAddress: ${(inquiry.fields["emailAddress"] as InquiryField.StringField).value}")
                Log.d("","currentSelfie: ${(inquiry.fields["currentSelfie"] as InquiryField.UnknownField).type}")
                Log.d("","addressStreet1: ${(inquiry.fields["addressStreet1"] as InquiryField.StringField).value}")
                Log.d("","addressStreet2: ${(inquiry.fields["addressStreet2"] as InquiryField.StringField).value}")
                Log.d("","selectedIdClass: ${(inquiry.fields["selectedIdClass"] as InquiryField.StringField).value}")
                Log.d("","addressPostalCode: ${(inquiry.fields["addressPostalCode"] as InquiryField.StringField).value}")
                Log.d("","addressSubdivision: ${(inquiry.fields["addressSubdivision"] as InquiryField.StringField).value}")
                Log.d("","addressCountryCode: ${(inquiry.fields["addressCountryCode"] as InquiryField.StringField).value}")
                Log.d("","identificationClass: ${(inquiry.fields["identificationClass"] as InquiryField.StringField).value}")
                Log.d("","currentGovernmentId: ${(inquiry.fields["currentGovernmentId"] as InquiryField.UnknownField).type}")
                Log.d("","identificationNumber: ${(inquiry.fields["identificationNumber"] as InquiryField.StringField).value}")
                Log.d("","selectedCountryCode: ${(inquiry.fields["selectedCountryCode"] as InquiryField.StringField).value}")
                Log.d("","socialSecurityNumber: ${(inquiry.fields["socialSecurityNumber"] as InquiryField.StringField).value}")
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
