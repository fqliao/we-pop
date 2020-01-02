package cn.webank.blockchain.contracts.web3j;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.abi.datatypes.generated.Int256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class CheckInfo extends Contract {
    public static String BINARY = "60806040526000600e553480156200001657600080fd5b506040516020806200121d8339810180604052810190808051906020019092919050505060206040519081016040528060008152506020604051908101604052806000815250816000908051906020019062000074929190620000f5565b5080600190805190602001906200008d929190620000f5565b505050620000aa81620000b1640100000000026401000000009004565b50620001a4565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200013857805160ff191683800117855562000169565b8280016001018555821562000169579182015b82811115620001685782518255916020019190600101906200014b565b5b5090506200017891906200017c565b5090565b620001a191905b808211156200019d57600081600090555060010162000183565b5090565b90565b61106980620001b46000396000f30060806040526004361061020f576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063019bfe83146102145780630ce432bb14610255578063142f31071461029e5780631864fa3a146102cb57806320f3f186146102f8578063212df0d214610325578063214277dc1461035057806323159b3b1461037b578063244e5841146103a657806327471426146103d1578063299e04e2146103fc578063366425aa1461042f57806336e6d6b41461046057806343dbf0351461048d578063454c9a5a146104ba578063529dc81c146104fb57806354de7bf114610526578063673506851461055157806367e4107f146105825780637082b6f0146105ad5780637b4832da146105da5780637d5301851461061d5780637ea9bf071461064a57806382a71fc4146106775780638bbeab97146106aa57806393d2f5ad146106d55780639f0dfecb14610700578063a24213bd14610731578063af1c9a5f1461075e578063b11b68831461078b578063b1deb9d21461081b578063b40bfca914610846578063bc1a7afd146108d6578063cdfe0d2014610901578063ce0111f31461092c578063d8fe547614610959578063e68ffd3c14610a88578063f03a841914610ab5578063f4cd650914610acc578063f72bd47014610af9578063f8049d0d14610b24578063fcebfaea14610b4f578063fede337014610b7a575b600080fd5b34801561022057600080fd5b5061023f60048036038101908080359060200190929190505050610ba5565b6040518082815260200191505060405180910390f35b34801561026157600080fd5b5061028060048036038101908080359060200190929190505050610bb3565b60405180826000191660001916815260200191505060405180910390f35b3480156102aa57600080fd5b506102c960048036038101908080359060200190929190505050610bd6565b005b3480156102d757600080fd5b506102f660048036038101908080359060200190929190505050610be0565b005b34801561030457600080fd5b5061032360048036038101908080359060200190929190505050610bea565b005b34801561033157600080fd5b5061033a610bf4565b6040518082815260200191505060405180910390f35b34801561035c57600080fd5b50610365610c01565b6040518082815260200191505060405180910390f35b34801561038757600080fd5b50610390610c07565b6040518082815260200191505060405180910390f35b3480156103b257600080fd5b506103bb610c0d565b6040518082815260200191505060405180910390f35b3480156103dd57600080fd5b506103e6610c13565b6040518082815260200191505060405180910390f35b34801561040857600080fd5b50610411610c19565b60405180826000191660001916815260200191505060405180910390f35b34801561043b57600080fd5b5061045e6004803603810190808035600019169060200190929190505050610c1f565b005b34801561046c57600080fd5b5061048b60048036038101908080359060200190929190505050610c54565b005b34801561049957600080fd5b506104b860048036038101908080359060200190929190505050610c5e565b005b3480156104c657600080fd5b506104e560048036038101908080359060200190929190505050610c68565b6040518082815260200191505060405180910390f35b34801561050757600080fd5b50610510610c8b565b6040518082815260200191505060405180910390f35b34801561053257600080fd5b5061053b610c91565b6040518082815260200191505060405180910390f35b34801561055d57600080fd5b506105806004803603810190808035600019169060200190929190505050610c97565b005b34801561058e57600080fd5b50610597610ca5565b6040518082815260200191505060405180910390f35b3480156105b957600080fd5b506105d860048036038101908080359060200190929190505050610cab565b005b3480156105e657600080fd5b5061061b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610cb5565b005b34801561062957600080fd5b5061064860048036038101908080359060200190929190505050610cf9565b005b34801561065657600080fd5b5061067560048036038101908080359060200190929190505050610d03565b005b34801561068357600080fd5b5061068c610d0d565b60405180826000191660001916815260200191505060405180910390f35b3480156106b657600080fd5b506106bf610d13565b6040518082815260200191505060405180910390f35b3480156106e157600080fd5b506106ea610d19565b6040518082815260200191505060405180910390f35b34801561070c57600080fd5b5061072f6004803603810190808035600019169060200190929190505050610d1f565b005b34801561073d57600080fd5b5061075c60048036038101908080359060200190929190505050610d2d565b005b34801561076a57600080fd5b5061078960048036038101908080359060200190929190505050610d37565b005b34801561079757600080fd5b506107a0610d41565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156107e05780820151818401526020810190506107c5565b50505050905090810190601f16801561080d5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561082757600080fd5b50610830610ddf565b6040518082815260200191505060405180910390f35b34801561085257600080fd5b5061085b610de5565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561089b578082015181840152602081019050610880565b50505050905090810190601f1680156108c85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156108e257600080fd5b506108eb610e83565b6040518082815260200191505060405180910390f35b34801561090d57600080fd5b50610916610e89565b6040518082815260200191505060405180910390f35b34801561093857600080fd5b5061095760048036038101908080359060200190929190505050610e8f565b005b34801561096557600080fd5b5061096e610e99565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b838110156109e45780820151818401526020810190506109c9565b50505050905090810190601f168015610a115780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b83811015610a4a578082015181840152602081019050610a2f565b50505050905090810190601f168015610a775780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b348015610a9457600080fd5b50610ab360048036038101908080359060200190929190505050611007565b005b348015610ac157600080fd5b50610aca611011565b005b348015610ad857600080fd5b50610af76004803603810190808035906020019092919050505061101b565b005b348015610b0557600080fd5b50610b0e611025565b6040518082815260200191505060405180910390f35b348015610b3057600080fd5b50610b3961102b565b6040518082815260200191505060405180910390f35b348015610b5b57600080fd5b50610b64611031565b6040518082815260200191505060405180910390f35b348015610b8657600080fd5b50610b8f611037565b6040518082815260200191505060405180910390f35b600081600f81905550919050565b600581815481101515610bc257fe5b906000526020600020016000915090505481565b8060128190555050565b8060138190555050565b8060158190555050565b6000600580549050905090565b60085481565b60155481565b600b5481565b600f5481565b600d5481565b600581908060018154018082558091505090600182039060005260206000200160009091929091909150906000191690555050565b8060068190555050565b80600a8190555050565b601681815481101515610c7757fe5b906000526020600020016000915090505481565b600c5481565b60135481565b80600d816000191690555050565b60125481565b8060078190555050565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b8060088190555050565b80600c8190555050565b60105481565b60035481565b60075481565b806010816000191690555050565b8060148190555050565b80600b8190555050565b60008054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610dd75780601f10610dac57610100808354040283529160200191610dd7565b820191906000526020600020905b815481529060010190602001808311610dba57829003601f168201915b505050505081565b600a5481565b60018054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610e7b5780601f10610e5057610100808354040283529160200191610e7b565b820191906000526020600020905b815481529060010190602001808311610e5e57829003601f168201915b505050505081565b60095481565b60115481565b8060038190555050565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f595780601f10610f2e57610100808354040283529160200191610f59565b820191906000526020600020905b815481529060010190602001808311610f3c57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ff55780601f10610fca57610100808354040283529160200191610ff5565b820191906000526020600020905b815481529060010190602001808311610fd857829003601f168201915b50505050509150925092509250909192565b8060118190555050565b6001600481905550565b8060098190555050565b60045481565b60065481565b60145481565b600e54815600a165627a7a72305820ff0b8e114cb93c5c2d4aab036618ada5e63ef8f29ccf7a96b851e16e8d0854c90029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[{\"name\":\"_lastCheckCode\",\"type\":\"int256\"}],\"name\":\"setLastCheckCode\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"orderList\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_totalTxAmt\",\"type\":\"int256\"}],\"name\":\"setTotalTxAmt\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_currency\",\"type\":\"int256\"}],\"name\":\"setCurrency\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_timestamp\",\"type\":\"int256\"}],\"name\":\"setTimestamp\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOrderListSize\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currencyCharge\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"timestamp\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"status\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"lastCheckCode\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"syncPath\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"order\",\"type\":\"bytes32\"}],\"name\":\"addOrder\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_accrual\",\"type\":\"int256\"}],\"name\":\"setAccrual\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"accrual_issuing\",\"type\":\"int256\"}],\"name\":\"setAccrualIssuing\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"checkCodeList\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"syncStatus\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"currency\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"sync_path\",\"type\":\"bytes32\"}],\"name\":\"setSyncPath\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"totalTxAmt\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"tx_charge\",\"type\":\"int256\"}],\"name\":\"setTxCharge\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"currency_charge\",\"type\":\"int256\"}],\"name\":\"setCurrencyCharge\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"sync_status\",\"type\":\"int256\"}],\"name\":\"setSyncStatus\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"walletOwnerOrg\",\"outputs\":[{\"name\":\"\",\"type\":\"bytes32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"checkCode\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"txCharge\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_walletOwnerOrg\",\"type\":\"bytes32\"}],\"name\":\"setWalletOwnerOrg\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_wbBalance\",\"type\":\"int256\"}],\"name\":\"setWbBalance\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_status\",\"type\":\"int256\"}],\"name\":\"setStatus\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"accrualIssuing\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"accrualAcquirer\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"totalRmbAmt\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"check_code\",\"type\":\"int256\"}],\"name\":\"setCheckCode\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_totalRmbAmt\",\"type\":\"int256\"}],\"name\":\"setTotalRmbAmt\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"setCheckCodeStatus\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"accrual_acquirer\",\"type\":\"int256\"}],\"name\":\"setAccrualAcquirer\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"checkCodeStatus\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"accrual\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"wbBalance\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"lastCheckCodeStatus\",\"outputs\":[{\"name\":\"\",\"type\":\"int256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"length\",\"type\":\"int256\"}],\"name\":\"debugOrderLog\",\"type\":\"event\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_SETLASTCHECKCODE = "setLastCheckCode";

    public static final String FUNC_ORDERLIST = "orderList";

    public static final String FUNC_SETTOTALTXAMT = "setTotalTxAmt";

    public static final String FUNC_SETCURRENCY = "setCurrency";

    public static final String FUNC_SETTIMESTAMP = "setTimestamp";

    public static final String FUNC_GETORDERLISTSIZE = "getOrderListSize";

    public static final String FUNC_CURRENCYCHARGE = "currencyCharge";

    public static final String FUNC_TIMESTAMP = "timestamp";

    public static final String FUNC_STATUS = "status";

    public static final String FUNC_LASTCHECKCODE = "lastCheckCode";

    public static final String FUNC_SYNCPATH = "syncPath";

    public static final String FUNC_ADDORDER = "addOrder";

    public static final String FUNC_SETACCRUAL = "setAccrual";

    public static final String FUNC_SETACCRUALISSUING = "setAccrualIssuing";

    public static final String FUNC_CHECKCODELIST = "checkCodeList";

    public static final String FUNC_SYNCSTATUS = "syncStatus";

    public static final String FUNC_CURRENCY = "currency";

    public static final String FUNC_SETSYNCPATH = "setSyncPath";

    public static final String FUNC_TOTALTXAMT = "totalTxAmt";

    public static final String FUNC_SETTXCHARGE = "setTxCharge";

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_SETCURRENCYCHARGE = "setCurrencyCharge";

    public static final String FUNC_SETSYNCSTATUS = "setSyncStatus";

    public static final String FUNC_WALLETOWNERORG = "walletOwnerOrg";

    public static final String FUNC_CHECKCODE = "checkCode";

    public static final String FUNC_TXCHARGE = "txCharge";

    public static final String FUNC_SETWALLETOWNERORG = "setWalletOwnerOrg";

    public static final String FUNC_SETWBBALANCE = "setWbBalance";

    public static final String FUNC_SETSTATUS = "setStatus";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_ACCRUALISSUING = "accrualIssuing";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_ACCRUALACQUIRER = "accrualAcquirer";

    public static final String FUNC_TOTALRMBAMT = "totalRmbAmt";

    public static final String FUNC_SETCHECKCODE = "setCheckCode";

    public static final String FUNC_GETMETA = "getMeta";

    public static final String FUNC_SETTOTALRMBAMT = "setTotalRmbAmt";

    public static final String FUNC_SETCHECKCODESTATUS = "setCheckCodeStatus";

    public static final String FUNC_SETACCRUALACQUIRER = "setAccrualAcquirer";

    public static final String FUNC_CHECKCODESTATUS = "checkCodeStatus";

    public static final String FUNC_ACCRUAL = "accrual";

    public static final String FUNC_WBBALANCE = "wbBalance";

    public static final String FUNC_LASTCHECKCODESTATUS = "lastCheckCodeStatus";

    public static final Event DEBUGORDERLOG_EVENT = new Event("debugOrderLog", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
    ;

    @Deprecated
    protected CheckInfo(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CheckInfo(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CheckInfo(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CheckInfo(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<BigInteger> setLastCheckCode(BigInteger _lastCheckCode) {
        final Function function = new Function(FUNC_SETLASTCHECKCODE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_lastCheckCode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> orderList(BigInteger param0) {
        final Function function = new Function(FUNC_ORDERLIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> setTotalTxAmt(BigInteger _totalTxAmt) {
        final Function function = new Function(
                FUNC_SETTOTALTXAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_totalTxAmt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTotalTxAmt(BigInteger _totalTxAmt, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTOTALTXAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_totalTxAmt)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTotalTxAmtSeq(BigInteger _totalTxAmt) {
        final Function function = new Function(
                FUNC_SETTOTALTXAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_totalTxAmt)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetTotalTxAmtInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTOTALTXAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setCurrency(BigInteger _currency) {
        final Function function = new Function(
                FUNC_SETCURRENCY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_currency)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCurrency(BigInteger _currency, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCURRENCY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_currency)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCurrencySeq(BigInteger _currency) {
        final Function function = new Function(
                FUNC_SETCURRENCY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_currency)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetCurrencyInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCURRENCY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setTimestamp(BigInteger _timestamp) {
        final Function function = new Function(
                FUNC_SETTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTimestamp(BigInteger _timestamp, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTimestampSeq(BigInteger _timestamp) {
        final Function function = new Function(
                FUNC_SETTIMESTAMP, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_timestamp)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetTimestampInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> getOrderListSize() {
        final Function function = new Function(FUNC_GETORDERLISTSIZE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> currencyCharge() {
        final Function function = new Function(FUNC_CURRENCYCHARGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> timestamp() {
        final Function function = new Function(FUNC_TIMESTAMP, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> status() {
        final Function function = new Function(FUNC_STATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> lastCheckCode() {
        final Function function = new Function(FUNC_LASTCHECKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<byte[]> syncPath() {
        final Function function = new Function(FUNC_SYNCPATH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<TransactionReceipt> addOrder(byte[] order) {
        final Function function = new Function(
                FUNC_ADDORDER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(order)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void addOrder(byte[] order, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ADDORDER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(order)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String addOrderSeq(byte[] order) {
        final Function function = new Function(
                FUNC_ADDORDER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(order)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<byte[]> getAddOrderInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDORDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setAccrual(BigInteger _accrual) {
        final Function function = new Function(
                FUNC_SETACCRUAL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_accrual)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setAccrual(BigInteger _accrual, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETACCRUAL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_accrual)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setAccrualSeq(BigInteger _accrual) {
        final Function function = new Function(
                FUNC_SETACCRUAL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_accrual)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetAccrualInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETACCRUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setAccrualIssuing(BigInteger accrual_issuing) {
        final Function function = new Function(
                FUNC_SETACCRUALISSUING, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(accrual_issuing)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setAccrualIssuing(BigInteger accrual_issuing, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETACCRUALISSUING, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(accrual_issuing)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setAccrualIssuingSeq(BigInteger accrual_issuing) {
        final Function function = new Function(
                FUNC_SETACCRUALISSUING, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(accrual_issuing)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetAccrualIssuingInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETACCRUALISSUING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> checkCodeList(BigInteger param0) {
        final Function function = new Function(FUNC_CHECKCODELIST, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> syncStatus() {
        final Function function = new Function(FUNC_SYNCSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> currency() {
        final Function function = new Function(FUNC_CURRENCY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setSyncPath(byte[] sync_path) {
        final Function function = new Function(
                FUNC_SETSYNCPATH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(sync_path)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setSyncPath(byte[] sync_path, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSYNCPATH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(sync_path)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setSyncPathSeq(byte[] sync_path) {
        final Function function = new Function(
                FUNC_SETSYNCPATH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(sync_path)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<byte[]> getSetSyncPathInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSYNCPATH, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> totalTxAmt() {
        final Function function = new Function(FUNC_TOTALTXAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setTxCharge(BigInteger tx_charge) {
        final Function function = new Function(
                FUNC_SETTXCHARGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(tx_charge)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTxCharge(BigInteger tx_charge, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTXCHARGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(tx_charge)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTxChargeSeq(BigInteger tx_charge) {
        final Function function = new Function(
                FUNC_SETTXCHARGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(tx_charge)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetTxChargeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTXCHARGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setMetaAddress(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMetaAddress(String meta, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMetaAddressSeq(String meta) {
        final Function function = new Function(
                FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetMetaAddressInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMETAADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setCurrencyCharge(BigInteger currency_charge) {
        final Function function = new Function(
                FUNC_SETCURRENCYCHARGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency_charge)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCurrencyCharge(BigInteger currency_charge, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCURRENCYCHARGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency_charge)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCurrencyChargeSeq(BigInteger currency_charge) {
        final Function function = new Function(
                FUNC_SETCURRENCYCHARGE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(currency_charge)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetCurrencyChargeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCURRENCYCHARGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setSyncStatus(BigInteger sync_status) {
        final Function function = new Function(
                FUNC_SETSYNCSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(sync_status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setSyncStatus(BigInteger sync_status, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSYNCSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(sync_status)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setSyncStatusSeq(BigInteger sync_status) {
        final Function function = new Function(
                FUNC_SETSYNCSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(sync_status)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetSyncStatusInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSYNCSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<byte[]> walletOwnerOrg() {
        final Function function = new Function(FUNC_WALLETOWNERORG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<BigInteger> checkCode() {
        final Function function = new Function(FUNC_CHECKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> txCharge() {
        final Function function = new Function(FUNC_TXCHARGE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setWalletOwnerOrg(byte[] _walletOwnerOrg) {
        final Function function = new Function(
                FUNC_SETWALLETOWNERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_walletOwnerOrg)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setWalletOwnerOrg(byte[] _walletOwnerOrg, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETWALLETOWNERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_walletOwnerOrg)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setWalletOwnerOrgSeq(byte[] _walletOwnerOrg) {
        final Function function = new Function(
                FUNC_SETWALLETOWNERORG, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(_walletOwnerOrg)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<byte[]> getSetWalletOwnerOrgInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETWALLETOWNERORG, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<byte[]>(

                (byte[]) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setWbBalance(BigInteger _wbBalance) {
        final Function function = new Function(
                FUNC_SETWBBALANCE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_wbBalance)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setWbBalance(BigInteger _wbBalance, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETWBBALANCE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_wbBalance)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setWbBalanceSeq(BigInteger _wbBalance) {
        final Function function = new Function(
                FUNC_SETWBBALANCE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_wbBalance)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetWbBalanceInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETWBBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setStatus(BigInteger _status) {
        final Function function = new Function(
                FUNC_SETSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_status)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setStatus(BigInteger _status, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_status)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setStatusSeq(BigInteger _status) {
        final Function function = new Function(
                FUNC_SETSTATUS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_status)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetStatusInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETSTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> accrualIssuing() {
        final Function function = new Function(FUNC_ACCRUALISSUING, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> abi() {
        final Function function = new Function(FUNC_ABI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> accrualAcquirer() {
        final Function function = new Function(FUNC_ACCRUALACQUIRER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalRmbAmt() {
        final Function function = new Function(FUNC_TOTALRMBAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setCheckCode(BigInteger check_code) {
        final Function function = new Function(
                FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(check_code)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCheckCode(BigInteger check_code, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(check_code)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCheckCodeSeq(BigInteger check_code) {
        final Function function = new Function(
                FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(check_code)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetCheckCodeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETCHECKCODE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<Tuple3<String, String, String>> getMeta() {
        final Function function = new Function(FUNC_GETMETA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<String, String, String>>(
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setTotalRmbAmt(BigInteger _totalRmbAmt) {
        final Function function = new Function(
                FUNC_SETTOTALRMBAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_totalRmbAmt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setTotalRmbAmt(BigInteger _totalRmbAmt, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETTOTALRMBAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_totalRmbAmt)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setTotalRmbAmtSeq(BigInteger _totalRmbAmt) {
        final Function function = new Function(
                FUNC_SETTOTALRMBAMT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(_totalRmbAmt)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetTotalRmbAmtInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETTOTALRMBAMT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setCheckCodeStatus() {
        final Function function = new Function(
                FUNC_SETCHECKCODESTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setCheckCodeStatus(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETCHECKCODESTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setCheckCodeStatusSeq() {
        final Function function = new Function(
                FUNC_SETCHECKCODESTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> setAccrualAcquirer(BigInteger accrual_acquirer) {
        final Function function = new Function(
                FUNC_SETACCRUALACQUIRER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(accrual_acquirer)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setAccrualAcquirer(BigInteger accrual_acquirer, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETACCRUALACQUIRER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(accrual_acquirer)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setAccrualAcquirerSeq(BigInteger accrual_acquirer) {
        final Function function = new Function(
                FUNC_SETACCRUALACQUIRER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Int256(accrual_acquirer)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetAccrualAcquirerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETACCRUALACQUIRER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> checkCodeStatus() {
        final Function function = new Function(FUNC_CHECKCODESTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> accrual() {
        final Function function = new Function(FUNC_ACCRUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> wbBalance() {
        final Function function = new Function(FUNC_WBBALANCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> lastCheckCodeStatus() {
        final Function function = new Function(FUNC_LASTCHECKCODESTATUS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Int256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public List<DebugOrderLogEventResponse> getDebugOrderLogEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEBUGORDERLOG_EVENT, transactionReceipt);
        ArrayList<DebugOrderLogEventResponse> responses = new ArrayList<DebugOrderLogEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DebugOrderLogEventResponse typedResponse = new DebugOrderLogEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.length = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerdebugOrderLogEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(DEBUGORDERLOG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerdebugOrderLogEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(DEBUGORDERLOG_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static CheckInfo load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CheckInfo(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CheckInfo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CheckInfo(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CheckInfo load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CheckInfo(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CheckInfo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CheckInfo(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CheckInfo> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(CheckInfo.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<CheckInfo> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(CheckInfo.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CheckInfo> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(CheckInfo.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<CheckInfo> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String meta) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(meta)));
        return deployRemoteCall(CheckInfo.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class DebugOrderLogEventResponse {
        public Log log;

        public BigInteger length;
    }
}
