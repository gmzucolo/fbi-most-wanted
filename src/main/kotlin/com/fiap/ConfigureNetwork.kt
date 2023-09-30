package com.fiap

import io.ktor.client.*
import io.ktor.client.engine.cio.CIO
import java.security.cert.X509Certificate
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object ConfigureNetwork {

   fun httpClientInstance() : HttpClient {
       return clientDev()
   }

    private fun clientDev() = HttpClient(CIO) {
        installJson()
        engine {
            https {
                trustManager = trustAllCerts()[0]
            }
        }
    }

    private fun trustAllCerts() = arrayOf<TrustManager>(
        object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                Unit
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                Unit
            }
            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        }
    )

}