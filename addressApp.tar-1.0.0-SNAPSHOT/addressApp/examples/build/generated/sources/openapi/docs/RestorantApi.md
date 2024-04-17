# RestorantApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createRestorant**](RestorantApi.md#createRestorant) | **POST** /restorant | Create a restorant |
| [**createRestorantWithHttpInfo**](RestorantApi.md#createRestorantWithHttpInfo) | **POST** /restorant | Create a restorant |
| [**listRestorants**](RestorantApi.md#listRestorants) | **GET** /restorant | List all restorants |
| [**listRestorantsWithHttpInfo**](RestorantApi.md#listRestorantsWithHttpInfo) | **GET** /restorant | List all restorants |



## createRestorant

> Restorant createRestorant(restorant)

Create a restorant

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RestorantApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        RestorantApi apiInstance = new RestorantApi(defaultClient);
        Restorant restorant = new Restorant(); // Restorant | 
        try {
            Restorant result = apiInstance.createRestorant(restorant);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RestorantApi#createRestorant");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **restorant** | [**Restorant**](Restorant.md)|  | |

### Return type

[**Restorant**](Restorant.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Null response |  -  |

## createRestorantWithHttpInfo

> ApiResponse<Restorant> createRestorant createRestorantWithHttpInfo(restorant)

Create a restorant

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RestorantApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        RestorantApi apiInstance = new RestorantApi(defaultClient);
        Restorant restorant = new Restorant(); // Restorant | 
        try {
            ApiResponse<Restorant> response = apiInstance.createRestorantWithHttpInfo(restorant);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling RestorantApi#createRestorant");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **restorant** | [**Restorant**](Restorant.md)|  | |

### Return type

ApiResponse<[**Restorant**](Restorant.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Null response |  -  |


## listRestorants

> List<Restorant> listRestorants()

List all restorants

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RestorantApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        RestorantApi apiInstance = new RestorantApi(defaultClient);
        try {
            List<Restorant> result = apiInstance.listRestorants();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RestorantApi#listRestorants");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**List&lt;Restorant&gt;**](Restorant.md)


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of restorant |  -  |

## listRestorantsWithHttpInfo

> ApiResponse<List<Restorant>> listRestorants listRestorantsWithHttpInfo()

List all restorants

### Example

```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RestorantApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        RestorantApi apiInstance = new RestorantApi(defaultClient);
        try {
            ApiResponse<List<Restorant>> response = apiInstance.listRestorantsWithHttpInfo();
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling RestorantApi#listRestorants");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

ApiResponse<[**List&lt;Restorant&gt;**](Restorant.md)>


### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | An array of restorant |  -  |

