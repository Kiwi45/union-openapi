package com.rarible.protocol.union.api.client

import com.rarible.protocol.union.api.ApiClient
import com.rarible.protocol.union.dto.OrderDto
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.util.LinkedMultiValueMap

/**
 * This API is only accessible inside cloud cluster, and can't be call directly by external clients.
 */
class AdminControllerApi(
    private val apiClient: ApiClient
) {
    suspend fun cancelOrder(id: String): OrderDto {
        val postBody: Any? = null
        val pathParams = hashMapOf("orderId" to id)

        val localVarAccepts = arrayOf(
            "application/json"
        )
        val localVarAccept = apiClient.selectHeaderAccept(localVarAccepts)
        val localVarContentTypes = arrayOf<String>()
        val localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes)
        val localVarReturnType: ParameterizedTypeReference<OrderDto> = object : ParameterizedTypeReference<OrderDto>() {}

        return apiClient.invokeAPI(
            "/admin/orders/{orderId}/cancel",
            HttpMethod.POST,
            pathParams.toMap(),
            LinkedMultiValueMap(),
            postBody,
            HttpHeaders(),
            LinkedMultiValueMap(),
            LinkedMultiValueMap(),
            localVarAccept,
            localVarContentType,
            arrayOf<String>(),
            localVarReturnType
        ).awaitSingle()
    }
}