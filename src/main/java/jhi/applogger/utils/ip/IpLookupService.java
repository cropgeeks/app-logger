package jhi.applogger.utils.ip;

import retrofit2.Call;
import retrofit2.http.*;

public interface IpLookupService
{
	@GET("json/{ip}")
	Call<IpApiLookupResponse> getIpDetails(@Path("ip") String ip);
}
