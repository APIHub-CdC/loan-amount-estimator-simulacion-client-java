package io.lae.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import io.lae.client.ApiClient;
import io.lae.client.ApiException;
import io.lae.client.ApiResponse;
import io.lae.client.Configuration;
import io.lae.client.Pair;
import io.lae.client.ProgressRequestBody;
import io.lae.client.ProgressResponseBody;
import io.lae.client.model.PeticionFolioConsulta;
import io.lae.client.model.Respuesta;

public class LoanAmountEstimatorSimulacionApi {
	private ApiClient apiClient;

	public LoanAmountEstimatorSimulacionApi() {
		this(Configuration.getDefaultApiClient());
	}

	public LoanAmountEstimatorSimulacionApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public okhttp3.Call getLAEByFolioConsultaCall(String xApiKey, PeticionFolioConsulta request,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = request;
		String localVarPath = "/folioConsulta";
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		if (xApiKey != null)
			localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		final String[] localVarAccepts = {

		};
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null)
			localVarHeaderParams.put("Accept", localVarAccept);
		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);
		if (progressListener != null) {
			apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
				@Override
				public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
					okhttp3.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener)).build();
				}
			});
		}
		String[] localVarAuthNames = new String[] {};
		return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams,
				localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	private okhttp3.Call getLAEByFolioConsultaValidateBeforeCall(String xApiKey, PeticionFolioConsulta request,
			final ProgressResponseBody.ProgressListener progressListener,
			final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		if (xApiKey == null) {
			throw new ApiException(
					"Missing the required parameter 'xApiKey' when calling getLAEByFolioConsulta(Async)");
		}

		okhttp3.Call call = getLAEByFolioConsultaCall(xApiKey, request, progressListener, progressRequestListener);
		return call;
	}

	public Respuesta getLAEByFolioConsulta(String xApiKey, PeticionFolioConsulta request) throws ApiException {
		ApiResponse<Respuesta> resp = getLAEByFolioConsultaWithHttpInfo(xApiKey, request);
		return resp.getData();
	}

	public ApiResponse<Respuesta> getLAEByFolioConsultaWithHttpInfo(String xApiKey, PeticionFolioConsulta request)
			throws ApiException {
		okhttp3.Call call = getLAEByFolioConsultaValidateBeforeCall(xApiKey, request, null, null);
		Type localVarReturnType = new TypeToken<Respuesta>() {
		}.getType();
		return apiClient.execute(call, localVarReturnType);
	}

}
