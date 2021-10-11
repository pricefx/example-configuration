def contractId = out.VolumeDiscountContract?.selectedContractId
if (contractId) {
    return api.getBaseURL() + "/app/#/contracts/detail/${contractId}/contractDetail"
}

