package cn.webank.blockchain.contracts.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
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
public class MerchantInfoFactory extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b506040516119e53803806119e583398101806040528101908080518201929190602001805182019291906020018051820192919060200180518201929190505050838381600090805190602001906100699291906101ce565b5080600190805190602001906100809291906101ce565b505050818161008d61024e565b808060200180602001838103835285818151815260200191508051906020019080838360005b838110156100ce5780820151818401526020810190506100b3565b50505050905090810190601f1680156100fb5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610134578082015181840152602081019050610119565b50505050905090810190601f1680156101615780820380516001836020036101000a031916815260200191505b50945050505050604051809103906000f080158015610184573d6000803e3d6000fd5b50600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050610283565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061020f57805160ff191683800117855561023d565b8280016001018555821561023d579182015b8281111561023c578251825591602001919060010190610221565b5b50905061024a919061025e565b5090565b604051610739806112ac83390190565b61028091905b8082111561027c576000816000905550600101610264565b5090565b90565b61101a806102926000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680637b4832da1461007d5780639c2852fe146100c0578063b11b68831461013f578063b40bfca9146101cf578063b7aec44a1461025f578063d8fe5476146102b6575b600080fd5b34801561008957600080fd5b506100be600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506103e5565b005b3480156100cc57600080fd5b506100fd60048036038101908080356000191690602001909291908035600019169060200190929190505050610429565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561014b57600080fd5b506101546104d6565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610194578082015181840152602081019050610179565b50505050905090810190601f1680156101c15780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101db57600080fd5b506101e4610574565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610224578082015181840152602081019050610209565b50505050905090810190601f1680156102515780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561026b57600080fd5b50610274610612565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156102c257600080fd5b506102cb610638565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b83811015610341578082015181840152602081019050610326565b50505050905090810190601f16801561036e5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156103a757808201518184015260208101905061038c565b50505050905090810190601f1680156103d45780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000808383600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166104596107a6565b80846000191660001916815260200183600019166000191681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019350505050604051809103906000f0801580156104c9573d6000803e3d6000fd5b5090508091505092915050565b60008054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561056c5780601f106105415761010080835404028352916020019161056c565b820191906000526020600020905b81548152906001019060200180831161054f57829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561060a5780601f106105df5761010080835404028352916020019161060a565b820191906000526020600020905b8154815290600101906020018083116105ed57829003601f168201915b505050505081565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106f85780601f106106cd576101008083540402835291602001916106f8565b820191906000526020600020905b8154815290600101906020018083116106db57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107945780601f1061076957610100808354040283529160200191610794565b820191906000526020600020905b81548152906001019060200180831161077757829003601f168201915b50505050509150925092509250909192565b604051610838806107b7833901905600608060405234801561001057600080fd5b5060405160608061083883398101806040528101908080519060200190929190805190602001909291908051906020019092919050505060206040519081016040528060008152506020604051908101604052806000815250816000908051906020019061007f929190610113565b508060019080519060200190610096929190610113565b505050826003816000191690555081600481600019169055506100c7816100cf640100000000026401000000009004565b5050506101b8565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061015457805160ff1916838001178555610182565b82800160010185558215610182579182015b82811115610181578251825591602001919060010190610166565b5b50905061018f9190610193565b5090565b6101b591905b808211156101b1576000816000905550600101610199565b5090565b90565b610671806101c76000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680637b4832da14610072578063b11b6883146100b5578063b40bfca914610145578063cf9ce6da146101d5578063d8fe547614610217575b600080fd5b34801561007e57600080fd5b506100b3600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610346565b005b3480156100c157600080fd5b506100ca61038a565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561010a5780820151818401526020810190506100ef565b50505050905090810190601f1680156101375780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561015157600080fd5b5061015a610428565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561019a57808201518184015260208101905061017f565b50505050905090810190601f1680156101c75780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101e157600080fd5b506101ea6104c6565b60405180836000191660001916815260200182600019166000191681526020019250505060405180910390f35b34801561022357600080fd5b5061022c6104d7565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b838110156102a2578082015181840152602081019050610287565b50505050905090810190601f1680156102cf5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156103085780820151818401526020810190506102ed565b50505050905090810190601f1680156103355780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104205780601f106103f557610100808354040283529160200191610420565b820191906000526020600020905b81548152906001019060200180831161040357829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104be5780601f10610493576101008083540402835291602001916104be565b820191906000526020600020905b8154815290600101906020018083116104a157829003601f168201915b505050505081565b600080600354600454915091509091565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105975780601f1061056c57610100808354040283529160200191610597565b820191906000526020600020905b81548152906001019060200180831161057a57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106335780601f1061060857610100808354040283529160200191610633565b820191906000526020600020905b81548152906001019060200180831161061657829003601f168201915b505050505091509250925092509091925600a165627a7a72305820e003d039ca8e117f52c334a69d944f0ece1c8971d68ec9e53f34ded6cd831bd60029a165627a7a723058203be57ee993ebdbc8e5bf32d3946b4f420d3afc597aed2a75acbc6e121c97cc6f0029608060405234801561001057600080fd5b5060405161073938038061073983398101806040528101908080518201929190602001805182019291905050508160009080519060200190610053929190610072565b50806001908051906020019061006a929190610072565b505050610117565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100b357805160ff19168380011785556100e1565b828001600101855582156100e1579182015b828111156100e05782518255916020019190600101906100c5565b5b5090506100ee91906100f2565b5090565b61011491905b808211156101105760008160009055506001016100f8565b5090565b90565b610613806101266000396000f300608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680637b4832da14610067578063b11b6883146100aa578063b40bfca91461013a578063d8fe5476146101ca575b600080fd5b34801561007357600080fd5b506100a8600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506102f9565b005b3480156100b657600080fd5b506100bf61033d565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100ff5780820151818401526020810190506100e4565b50505050905090810190601f16801561012c5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561014657600080fd5b5061014f6103db565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561018f578082015181840152602081019050610174565b50505050905090810190601f1680156101bc5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156101d657600080fd5b506101df610479565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019080838360005b8381101561025557808201518184015260208101905061023a565b50505050905090810190601f1680156102825780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b838110156102bb5780820151818401526020810190506102a0565b50505050905090810190601f1680156102e85780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103d35780601f106103a8576101008083540402835291602001916103d3565b820191906000526020600020905b8154815290600101906020018083116103b657829003601f168201915b505050505081565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104715780601f1061044657610100808354040283529160200191610471565b820191906000526020600020905b81548152906001019060200180831161045457829003601f168201915b505050505081565b6060806000806001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105395780601f1061050e57610100808354040283529160200191610539565b820191906000526020600020905b81548152906001019060200180831161051c57829003601f168201915b50505050509250818054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105d55780601f106105aa576101008083540402835291602001916105d5565b820191906000526020600020905b8154815290600101906020018083116105b857829003601f168201915b505050505091509250925092509091925600a165627a7a72305820f617b3ee499d4043dc29c28f8a7e4be5a3862f00075380a3a00be3997550fea40029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"meta\",\"type\":\"address\"}],\"name\":\"setMetaAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"id\",\"type\":\"bytes32\"},{\"name\":\"name\",\"type\":\"bytes32\"}],\"name\":\"create\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"name\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"abi\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"merchantinfometa\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMeta\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"abi\",\"type\":\"string\"},{\"name\":\"merchantinfoname\",\"type\":\"string\"},{\"name\":\"merchantinfoabi\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_SETMETAADDRESS = "setMetaAddress";

    public static final String FUNC_CREATE = "create";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_ABI = "abi";

    public static final String FUNC_MERCHANTINFOMETA = "merchantinfometa";

    public static final String FUNC_GETMETA = "getMeta";

    @Deprecated
    protected MerchantInfoFactory(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MerchantInfoFactory(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MerchantInfoFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MerchantInfoFactory(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
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

    public RemoteCall<TransactionReceipt> create(byte[] id, byte[] name) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(id), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void create(byte[] id, byte[] name, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(id), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(name)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createSeq(byte[] id, byte[] name) {
        final Function function = new Function(
                FUNC_CREATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(id), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Bytes32(name)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<byte[], byte[]> getCreateInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<byte[], byte[]>(

                (byte[]) results.get(0).getValue(), 
                (byte[]) results.get(1).getValue()
                );
    }

    public Tuple1<String> getCreateOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_CREATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> abi() {
        final Function function = new Function(FUNC_ABI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> merchantinfometa() {
        final Function function = new Function(FUNC_MERCHANTINFOMETA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    @Deprecated
    public static MerchantInfoFactory load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerchantInfoFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MerchantInfoFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MerchantInfoFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MerchantInfoFactory load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MerchantInfoFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MerchantInfoFactory load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MerchantInfoFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MerchantInfoFactory> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String name, String abi, String merchantinfoname, String merchantinfoabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoabi)));
        return deployRemoteCall(MerchantInfoFactory.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<MerchantInfoFactory> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String name, String abi, String merchantinfoname, String merchantinfoabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoabi)));
        return deployRemoteCall(MerchantInfoFactory.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MerchantInfoFactory> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String name, String abi, String merchantinfoname, String merchantinfoabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoabi)));
        return deployRemoteCall(MerchantInfoFactory.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<MerchantInfoFactory> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String name, String abi, String merchantinfoname, String merchantinfoabi) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(name), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(abi), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoname), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(merchantinfoabi)));
        return deployRemoteCall(MerchantInfoFactory.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
