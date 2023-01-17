package com.westeros.diagnostics;

import com.westeros.data.repositories.ICatalogData;
import com.westeros.diagnostics.runners.IDiagnose;
import com.westeros.diagnostics.service.contract.Diagnostics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseConnectivityDiagnostics implements IDiagnose
{
    private final ICatalogData db;

    @Override
    public String getName() {
        return "DB test";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public Diagnostics run() {
        var result = new Diagnostics();
        result.setName(getName());
        result.setDescription(getDescription());
        try{
            var tst = db.getMovies().count();
            result.setSuccess(true);
        }catch(Exception ex){
            result.setSuccess(false);
            result.setErrorMessage(ex.getMessage());
        }
        return result;
    }
}
